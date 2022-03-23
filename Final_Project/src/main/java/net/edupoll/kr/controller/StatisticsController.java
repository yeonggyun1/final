package net.edupoll.kr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import net.edupoll.kr.service.StatisticsService;

@Controller
@RequestMapping("/statistics")
public class StatisticsController {
	@Autowired
	StatisticsService statisticsService;
	
	@RequestMapping("/message")
	public String messageHandle() {
		return "statistics/message";
	}
	
	@RequestMapping("/message/data")
	@ResponseBody
	public List<Object[]> messageDataHandle() {
		List<Object[]> ret = statisticsService.getMessageCountingPerHours();
		
		Gson gson = new Gson();
		//System.out.println(gson.toJson(ret));
		
		return ret;
	}
	
	
	
}
