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

import jp.co.opst.Dto.ReserveDto;
import jp.co.opst.Entity.ReserveEntity;
import jp.co.opst.Model.ReserveInfoModel;
import jp.co.opst.Model.ReserveModel;
import jp.co.opst.Service.ReserveOperateService;

@Controller
public class ReserveInfoController {
	public static final double TAX = 0.08;
	@Autowired
	private ReserveOperateService reserveOperateService;

	@RequestMapping("/reserveDisplay")
	public String showForm() {
		return "ReserveOperate/reserveInfo";
	}

	@RequestMapping(path = "/reserveInfo", method = RequestMethod.POST)
	public ModelAndView serchInfo(@Valid @ModelAttribute ReserveInfoModel resimo, BindingResult errors,
			HttpSession session) {
		if (errors.hasErrors()) {
			ModelAndView mv = new ModelAndView("ReserveOperate/reserveInfo");
			return mv;
		} else {
			ReserveDto rdt = reserveOperateService.infoFind(resimo);
			if (rdt.getResList().size() == 0) {
				String message = "検索件数は0件です";
				ModelAndView mv = new ModelAndView("ReserveOperate/reserveInfo", "zeroError", message);
				return mv;
			} else {
				String dep = null;
				String arr = null;
				int price = 0;
				int memNum = 0;
				for (ReserveEntity b : rdt.getResList()) {
					dep = b.getStartDay();
					arr = b.getFinishDay();
					price = b.getPrice();
					memNum = b.getMemNum();
				}
				String str = String.format("%05d", memNum);
				//------------------------------------
				int tax = (int) (price * TAX);
				int total = tax + price;
				try {
					SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
					SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd");
					long depDate = d.parse(dep).getTime();
					long arrDate = a.parse(arr).getTime();
					int diffDays = (int) ((arrDate - depDate) / (1000 * 60 * 60 * 24));
					session.setAttribute("days", diffDays);
				} catch (ParseException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				session.setAttribute("memNum", str);
				session.setAttribute("total", total);
				session.setAttribute("tax", tax);
				session.setAttribute("price", price);
				session.setAttribute("dep", dep);
				session.setAttribute("arr", arr);
				session.setAttribute("resInfo", rdt);
				ModelAndView mv = new ModelAndView("ReserveOperate/reserveInfo");
				return mv;
			}

		}

	}

	@RequestMapping(path = "/cancelConf", method = RequestMethod.POST)
	public ModelAndView cancelConf() {
		ModelAndView mv = new ModelAndView("ReserveOperate/cancelConf");
		return mv;

	}

	@RequestMapping(path = "/cancelDo", method = RequestMethod.POST)
	public ModelAndView cancelDo(HttpSession session) {

		ReserveDto info = (ReserveDto) session.getAttribute("resInfo");
		ModelAndView mv = null;
		try {
			boolean res = reserveOperateService.cancel(info);
			if (res) {
				session.removeAttribute("memNum");
				session.removeAttribute("total");
				session.removeAttribute("tax");
				session.removeAttribute("price");
				session.removeAttribute("dep");
				session.removeAttribute("arr");
				session.removeAttribute("resInfo");
				mv = new ModelAndView("Main/menu");

			} else {
				mv = new ModelAndView("Error/error");

			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping(path = "/changeForm", method = RequestMethod.POST)
	public ModelAndView showForm(HttpSession session) {

		ModelAndView mv = new ModelAndView("ReserveOperate/reserveChange");
		return mv;
	}

	@RequestMapping(path = "/changeConf", method = RequestMethod.POST)
	public ModelAndView ChangeDo(@ModelAttribute ReserveModel resmo, HttpSession session) {
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
			//-------------------------------------------------------------------
			long dDates = d.parse(dep).getTime();
			long aDates = a.parse(arr).getTime();
			int diffDays = (int) ((aDates - dDates) / (1000 * 60 * 60 * 24));
			session.setAttribute("days", diffDays);

			//------------------------------------------------------------------
			int price = Integer.parseInt(session.getAttribute("days").toString())
					* Integer.parseInt(session.getAttribute("price").toString());
			int tax = (int) (price * TAX);
			int total = tax + price;
			session.setAttribute("price", price);
			session.setAttribute("tax", tax);
			session.setAttribute("total", total);
			//--------------------------------------------------------------------
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		session.setAttribute("dep", dep);
		session.setAttribute("arr", arr);
		//-----------------------------------
		ModelAndView mv = new ModelAndView("ReserveOperate/changeConf");
		return mv;

	}

	@RequestMapping(path = "/changeDo", method = RequestMethod.POST)
	public ModelAndView changeDo(HttpSession session) {
		String dep = session.getAttribute("dep").toString();
		String arr = session.getAttribute("arr").toString();
		ReserveDto info = (ReserveDto) session.getAttribute("resInfo");
		String price = session.getAttribute("price").toString();
		ReserveDto rdt = null;
		try {
			boolean res = reserveOperateService.change(dep, arr, info, price);
			if (res) {
				rdt = reserveOperateService.display(info);
			} else {
				ModelAndView mv = new ModelAndView("Error/error");
				return mv;

			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		for (ReserveEntity r : rdt.getResList()) {
			dep = r.getStartDay();
			arr = r.getFinishDay();
		}
		session.setAttribute("dep", dep);
		session.setAttribute("arr", arr);
		ModelAndView mv = new ModelAndView("ReserveOperate/reserveInfo");
		return mv;
	}
}
