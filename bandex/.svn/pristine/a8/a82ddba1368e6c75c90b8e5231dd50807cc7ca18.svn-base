package com.bandex.backend.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BackendLogoutController extends BackendBaseController {

	@RequestMapping(value = "/logout")
	public String login(HttpServletRequest req) {
		req.getSession().invalidate();
		return "redirect:/login";
	}
}
