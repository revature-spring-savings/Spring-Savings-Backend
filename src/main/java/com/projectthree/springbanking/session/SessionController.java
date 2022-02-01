package com.projectthree.springbanking.session;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SessionController {

	@PostMapping("/startsession") 					//associated with login button
	public String loggedIn(@RequestParam("userin") String userin, HttpServletRequest request) {  
																										//Getting user information from the request session
		List<String> usersin = (List<String>) request.getSession().getAttribute("USER_SESSION"); 
																										//Checking if user if present in the session
				if (usersin == null){
				usersin = new ArrayList<>();
																										//If the object is not present select the user in the request session
				request.getSession().setAttribute("USER_SESSION", usersin);
				}
				usersin.add(userin);
				  request.getSession().setAttribute("USER_SESSION", usersin);
				  return "redirect:(our home or logged in /call)";			  
	}
	
	@GetMapping("/call for homescreen or loggin landing")
	public String landing(Model model, HttpSession session) {
		List<String> usersin = (List<String>) session.getAttribute("USER_SESSION");
		model.addAttribute("userSession", usersin!=null? usersin:new ArrayList<>());
		return "home or landing";
	}
	
	@PostMapping("/endsession") 		 //associated with log out button
	public String endSession(HttpServletRequest request) {
		request.getSession().invalidate();																//ends session and clears data from session database
		return "redirect:(home or loggin page)";
	}
	
	
}
