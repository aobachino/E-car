package jp.co.opst.Controller;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.opst.Model.RegisterModel;
import jp.co.opst.Service.RegisterService;

@Controller
public class RegisterController {

	@Autowired
	private RegisterService registerService;

	@RequestMapping("/registerForm")
	public String showForm() {
		return "NewRegister/registerForm";
	}

	@RequestMapping(path = "/registerConf", method = RequestMethod.POST)
	public ModelAndView regConf(@Valid @ModelAttribute RegisterModel regmo, BindingResult errors) {
		if (errors.hasErrors()) {
			ModelAndView mv = new ModelAndView("NewRegister/registerForm");
			return mv;

		} else {
			ModelAndView mv = new ModelAndView("NewRegister/registerConf", "registerForm", regmo);
			return mv;
		}
	}

	@RequestMapping(path = "/registerCheck", method = RequestMethod.POST)
	public ModelAndView regCheck(@ModelAttribute RegisterModel regmo) {

		try {
			registerService.insert(regmo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int userNum = registerService.findUserNum();
		String str = String.format("%05d", userNum);
		return new ModelAndView("NewRegister/registerOk", "registerForm", str);
	}

}
