package net.edupoll.kr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import net.edupoll.kr.entity.FreeBoardVo;
import net.edupoll.kr.service.FreeBoardService;

@Controller
@RequestMapping("/freeboard")
public class FreeBoardController {
	@Autowired
	FreeBoardService freeBoardService;

	@RequestMapping(method = RequestMethod.GET)
	public String defaultHandle(Model model) {

		model.addAttribute("all", freeBoardService.getAll());

		return "freeboard/list";
	}

	@RequestMapping(path = "/insert", method = RequestMethod.GET)
	public String insertGetHandle(Model model) {

		return "freeboard/insert";
	}

	@RequestMapping(path = "/insert", method = RequestMethod.POST)
	public String insertPostHandle(@ModelAttribute("vo") FreeBoardVo vo, Model model) {
		boolean rst = freeBoardService.addNewOne(vo);
		if (!rst) {
			return "freeboard/insert";
		}

		return "redirect:/freeboard";
	}

	@RequestMapping("/freeboard/view")
	public String insertPostHandle(@RequestParam int no, Model model,
			@SessionAttribute(required = false) Boolean auth) {

		FreeBoardVo vo = freeBoardService.getOneByNo(no);
		if (vo == null) {
			return "redirect:/freeboard";
		}
		model.addAttribute("one", vo);

		return "freeboard/view";
	}
}
