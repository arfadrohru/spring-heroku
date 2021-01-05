package com.deploy.heroku.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "https://deploy-react-heroku.herokuapp.com")
@RestController
@RequestMapping("/api")
public class HerokuController {

	@GetMapping("/user")
	public Map<String, Object> getUser(){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("user", "Heroku");
		return result;
	}
}
