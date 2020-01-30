package com.test;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CookieController {

	@GetMapping("/")
	public String readCookie(@CookieValue(value = "username", defaultValue = "DefaultName") String username) {
	    return "Hey! My username is " + username;
	}
	
	@GetMapping("/change")
	public String setCookie(HttpServletResponse response, @RequestParam String username) {
	    // create a cookie
	    Cookie cookie = new Cookie("username", username);
	    //add cookie to response
	    cookie.setSecure(true);
	    response.addCookie(cookie);
	    return "Username is changed to " + username + "!!!";
	}
	
}
