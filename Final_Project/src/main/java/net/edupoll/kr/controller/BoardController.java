package net.edupoll.kr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.edupoll.kr.service.FreeBoardService;

@Controller
public class BoardController {

	@Autowired
	FreeBoardService freeBoardService;

	@RequestMapping("/list")
	public String listHandle(Model model) {
		model.addAttribute(freeBoardService.getAll());

		return "/freeboard/list";
	}
}
