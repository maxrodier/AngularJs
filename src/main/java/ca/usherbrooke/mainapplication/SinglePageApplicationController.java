package ca.usherbrooke.mainapplication;

import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.savedrequest.DefaultSavedRequest;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SinglePageApplicationController {
	
	@RequestMapping("/")
	public String index() {
		return "views/index.html";
	}
	
	private RequestCache requestCache = new HttpSessionRequestCache();
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request, HttpServletResponse response) {
		String attribute = (String) request.getParameter("redirect");
		if(attribute == null) {
			DefaultSavedRequest savedRequest = (DefaultSavedRequest) requestCache.getRequest(request, response);
			String redirectURI;
			if(savedRequest == null) { 
				redirectURI = "/";
			} else {
				redirectURI = savedRequest.getRequestURI();
			}
			return "redirect:/login?redirect=".concat(Base64.getEncoder().encodeToString(redirectURI.getBytes()));
		}
		return "views/login.html";
	}
}
