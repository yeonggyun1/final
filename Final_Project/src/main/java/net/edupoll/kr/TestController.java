package net.edupoll.kr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.edupoll.kr.service.MailService;

@Controller
public class TestController {

	@Autowired
	MailService mailService;
	
	@ResponseBody
	@RequestMapping("/mailtest")
	public String testHandle(@RequestParam String target) {

		boolean r = mailService.sendTestHTMLMail(target);
		
		return String.valueOf(r);				
	}
	
}




