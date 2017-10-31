package com.niit.discussionB.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController 
{
	@RequestMapping("/")
	public String serveHomepage(HttpServletRequest request){
		return "index";
	}

}
