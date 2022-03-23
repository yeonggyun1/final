package net.edupoll.kr.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.edupoll.kr.entity.AccountVo;
import net.edupoll.kr.service.AccountService;

@Controller
public class LoginController {
	@Autowired
	AccountService accountService;

	@RequestMapping("/login")
	public String loginHandle() {
		return "login";
	}

	@PostMapping("/session")
	public String sessionHandle(HttpSession session, @RequestParam String loginId, @RequestParam String loginPass, Model model) {
		boolean valid = accountService.isValidAccount(loginId, loginPass);
		if (valid) {
			AccountVo vo = accountService.findAccountById(loginId);
			// vo == null ?
			session.setAttribute("loginUser", vo);
			return "redirect:/";
		} else {
			model.addAttribute("err", "error");
			return "login";
		}
	}
	
	@RequestMapping("/logout")
	public String logoutHandle(HttpSession session) {
		session.removeAttribute("loginUser");
		
		session.invalidate();	// 사용자세션을 리셋
		return "redirect:/";
	}

}






