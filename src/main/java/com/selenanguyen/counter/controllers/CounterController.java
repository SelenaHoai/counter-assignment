package com.selenanguyen.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {
	@RequestMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count",1);
		}
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter(HttpSession session, Model model) {
		Integer currentCount =(Integer) session.getAttribute("count");
		model.addAttribute("countToShow", currentCount);
		
		session.setAttribute("count", currentCount +1);
		System.out.println(session.getAttribute("count"));
		
		return "counter.jsp";
	}
	
	@RequestMapping("/third")
	public String third(HttpSession session, Model model) {
		Integer currentCount =(Integer) session.getAttribute("count");
		model.addAttribute("countToShow", currentCount);
		
		session.setAttribute("count", currentCount +2);
		System.out.println(session.getAttribute("count"));
		
		return "third.jsp";
	}
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		
		session.setAttribute("count", 1);
		System.out.println(session.getAttribute("count"));
		
		return "index.jsp";
	}
	

}
