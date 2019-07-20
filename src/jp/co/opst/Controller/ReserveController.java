package jp.co.opst.Controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.opst.Dto.CategoryDto;
import jp.co.opst.Dto.ReserveDto;
import jp.co.opst.Model.ReserveConfModel;
import jp.co.opst.Model.ReserveModel;
import jp.co.opst.Model.ReserveOkModel;
import jp.co.opst.Service.CarService;
import jp.co.opst.Service.CategoryService;
import jp.co.opst.Service.ReserveService;

@Controller
public class ReserveController {
	public static final double TAX = 0.08;

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private CarService carService;
	@Autowired
	private ReserveService reserveService;

	@RequestMapping("/reserveForm")
	public ModelAndView showHome(HttpSession session) {
		CategoryDto categoryInfo = categoryService.findCategory();
		session.setAttribute("category", categoryInfo);
		return new ModelAndView("Reserve/reserveForm");
	}

	@RequestMapping(path = "/reserveSerch", method = RequestMethod.POST)
	public ModelAndView showSerch(@Valid @ModelAttribute ReserveModel resmo, BindingResult errors,
			HttpSession session) {
		if (errors.hasErrors()) {
			ModelAndView mv = new ModelAndView("Reserve/reserveForm");
			return mv;
		} else if ((resmo.getArrDay() == null) || (resmo.getArrMounth() == null) || (resmo.getArrYear() == null)
				|| (resmo.getDepDay() == null) || (resmo.getDepMounth() == null) || (resmo.getDepYear() == null)) {

			String message = "必須入力です";
			ModelAndView mv = new ModelAndView("Reserve/reserveForm", "dateError", message);
			return mv;

		} else {
			String dep = resmo.getDepYear() + "年" + resmo.getDepMounth() + "月" + resmo.getDepDay() + "日";
			String arr = resmo.getArrYear() + "年" + resmo.getArrMounth() + "月" + resmo.getArrDay() + "日";
			SimpleDateFormat d = new SimpleDateFormat("yyyy年MM月dd日");
			SimpleDateFormat a = new SimpleDateFormat("yyyy年MM月dd日");
			try {
				Date depDate = d.parse(dep);
				Date arrDate = a.parse(arr);

				if (depDate.after(arrDate)) {
					String massage = "出発日が返却日以降の日付で入力されています";
					ModelAndView mv = new ModelAndView("Reserve/reserveForm", "dateError", massage);
					return mv;
				}
			} catch (ParseException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			ReserveDto rdt = carService.productSerch(resmo);
			if (rdt.getMemList().size() == 0) {
				String message = "会員情報が存在しません";
				ModelAndView mv = new ModelAndView("Reserve/reserveForm", "memError", message);
				return mv;
			} else if (rdt.getCarList().size() == 0) {
				String message = "該当データがありません";
				ModelAndView mv = new ModelAndView("Reserve/reserveForm", "zeroError", message);
				return mv;
			}
			String memNum = String.format("%05d", Integer.parseInt(resmo.getMemNum()));
			session.setAttribute("memNum", memNum);
			session.setAttribute("dep", dep);
			session.setAttribute("arr", arr);
			ModelAndView mv = new ModelAndView("Reserve/reserveForm", "reserveInfo", rdt);
			return mv;
		}
	}

	@RequestMapping(path = "/reserveConf", method = RequestMethod.POST)
	public ModelAndView resvConf(@ModelAttribute ReserveConfModel rescomo, HttpSession session) {
		ReserveDto rdt = carService.productSelect(rescomo);

		SimpleDateFormat d = new SimpleDateFormat("yyyy年MM月dd日");
		SimpleDateFormat a = new SimpleDateFormat("yyyy年MM月dd日");
		try {
			long depDate = d.parse(rescomo.getDepDate()).getTime();
			long arrDate = a.parse(rescomo.getArrDate()).getTime();
			int diffDays = (int) ((arrDate - depDate) / (1000 * 60 * 60 * 24));
			session.setAttribute("days", diffDays);
			int price = carService.totalPrice(rescomo) * diffDays;
			int tax = (int) (price * TAX);
			int total = tax + price;
			session.setAttribute("price", price);
			session.setAttribute("tax", tax);
			session.setAttribute("total", total);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		ModelAndView mv = new ModelAndView("Reserve/reserveConf", "reserveInfo", rdt);
		return mv;
	}

	@RequestMapping(path = "/reserveOk", method = RequestMethod.POST)
	public ModelAndView reserveOk(@ModelAttribute ReserveOkModel okmo, HttpSession session) {
		ReserveDto rdt = null;
		try {
			String memNum = session.getAttribute("memNum").toString();
			rdt = reserveService.insert(okmo, memNum);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		ModelAndView mv = new ModelAndView("Reserve/reserveOk", "colleNum", rdt);
		session.removeAttribute("dep");
		session.removeAttribute("arr");
		return mv;
	}
}
