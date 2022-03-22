package net.edupoll.kr.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import net.edupoll.kr.entity.AccountVo;
import net.edupoll.kr.service.AccountService;
import net.edupoll.kr.service.MailService;

@SessionAttributes("loginUser")
@Controller
public class PersonalController {

	@Autowired
	AccountService accountService;
	@Autowired
	MailService mailService;
	
	
	@RequestMapping("/settings")
	public String settingsHandle() {
		return "personal/settings";
	}

	@PostMapping("/settings/modify")
	public String settingsModifyHandle(@ModelAttribute("loginUser") AccountVo vo, 
											HttpSession session, Model model) {
		boolean r = accountService.modifyAccount(vo);
		if (r) {
			AccountVo reVo = accountService.findAccountById(vo.getUserId());
			session.setAttribute("loginUser", reVo);
			return "redirect:/settings";
		} else {
			model.addAttribute("err", "errr");
			return "personal/settings";
		}
	}

	@RequestMapping("/settings/auth")
	public String settingsAuthHandle() {
		return "personal/auth";
	}
	
	
	@ResponseBody
	@RequestMapping("/settings/reqAuth")
	public Map<String, Object> reqAuthHandle(@ModelAttribute("loginUser") AccountVo vo, HttpSession session) {

		Map<String, Object> rst = mailService.sendAuthMailTo(vo.getEmail());
		
		if(rst.containsKey("authKey")) {
			session.setAttribute("authKey", rst.get("authKey"));
			rst.remove("authKey");
		}
		return rst;
	}

	@RequestMapping("/settings/verify")
	public String verifyHandle(@ModelAttribute AccountVo vo, 
			HttpSession session, @RequestParam String key, Model model) {
		
		String authKey =(String)session.getAttribute("authKey");
		if(authKey.equals(key)) {
			AccountVo loginVo = (AccountVo)session.getAttribute("loginUser");
			
			vo.setAuth("Y");
			vo.setUserId(loginVo.getUserId());
			
			accountService.modifyAccount(vo);
			
			AccountVo reVo = accountService.findAccountById(vo.getUserId());
			session.setAttribute("loginUser", reVo);
			return "redirect:/settings/auth";
		}else {
			model.addAttribute("err", "errr");
			return "personal/auth";
		}
		
	}
}
