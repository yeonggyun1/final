package net.edupoll.kr.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import net.edupoll.kr.entity.AccountVo;
import net.edupoll.kr.service.CommonService;
import net.edupoll.kr.service.SignUpService;


@SessionAttributes("accountVo")
@Controller
public class SignUpController {
	@Autowired
	SignUpService signUpService;
	
	@ModelAttribute("nav")
	public String nav() {
		return "sign";
	}
	@ModelAttribute
	public AccountVo defaultModel() {
		return new AccountVo();
	}
	
	@RequestMapping(path = "/signup", method = RequestMethod.GET)
	public String singup1Handle(Model model) {

		return "signup/signup";
	}

	
	@RequestMapping(path = "/signup", method = RequestMethod.POST)
	public String singup2Handle(@ModelAttribute @Valid AccountVo vo, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			return "signup/signup";
		}
		
		return "signup/signup2";
	}

	@PostMapping("/signupOk")
	public String singupOkHandle(@ModelAttribute @Valid AccountVo vo, BindingResult result) {
		if (result.hasErrors()) {
			return "signup/signup2";
		}
		boolean r = signUpService.registerAccount(vo);
	
		
		return "signup/signupOk";
	}
	
	@Autowired
	CommonService commonService;
	
	
	@ResponseBody
	@RequestMapping("/find/zipcode")
	public List<Map> findZipcodeHandle(@RequestParam String data ) {
		List<Map> li =commonService.findZipcode(data);
		
		return li;
	}
	
	
	
	/*
	 * @InitBinder public void initBinder(WebDataBinder binder) {
	 * System.out.println("initBinder..."); binder.addValidators(new
	 * AccountValidator()); }
	 */

	/*
	 * @RequestMapping(path="/signup", method=RequestMethod.POST) public String
	 * singup2Handle(@ModelAttribute AccountVo vo , BindingResult result , Model
	 * model) { System.out.println(result.hasErrors()); new
	 * AccountValidator().validate(vo, result);
	 * System.out.println(result.hasErrors()); if(result.hasErrors()) {
	 * System.out.println("result.hasErrors()"); for(ObjectError o :
	 * result.getAllErrors()) { System.out.println(o.getCode() + " : " +
	 * o.getDefaultMessage()); } return "signup"; } System.out.println(vo); return
	 * "signup2"; }
	 */
}
