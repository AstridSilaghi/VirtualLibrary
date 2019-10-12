package com.project.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomePageController extends ControllerBasic {

	@RequestMapping("/toHomePage")
	public ModelAndView goToHomePage()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("homePage");
		logedInUser = LogedInUser.getInstance();
		mv.addObject("username", logedInUser.getUserName());
		
		return mv;
	}
}
