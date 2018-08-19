package com.faye.flightSchedule.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {

	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is welcome page!");
		model.setViewName("welcome");
		return model;

	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is protected page!");
		model.setViewName("admin");

		return model;

	}

	//Spring Security see this :
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginGet() {

		ModelAndView model = new ModelAndView();

		model.setViewName("login");

		return model;

	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginPut() {

		ModelAndView model = new ModelAndView();

		model.setViewName("welcome");

		return model;

	}
	
	@RequestMapping(value = "/register", method = RequestMethod.PUT)
	public ModelAndView register() {

		ModelAndView model = new ModelAndView();

		model.setViewName("register");

		return model;

	}

}