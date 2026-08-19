package com.synergiz.itctc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReactController {

	@GetMapping(value = { "/", "/dashboard", "/login", "/profile" })
	public String reactRoutes() {
		return "forward:/index.html";
	}
}