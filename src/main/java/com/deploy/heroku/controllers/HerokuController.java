package com.deploy.heroku.controllers;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deploy.heroku.dtos.UserDTO;
import com.deploy.heroku.models.User;
import com.deploy.heroku.repositories.UserRepository;



@CrossOrigin(origins = "https://deploy-react-heroku.herokuapp.com")
@RestController
@RequestMapping("/api")
public class HerokuController {
	
	ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	UserRepository userRepo;
	
	@GetMapping("/user")
	public Map<String, Object> getUser(){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("user", "Heroku");
		return result;
	}

	@PostMapping("/create")
	public Map<String, Object> create(@RequestBody UserDTO body){
		Map<String, Object> result = new HashMap<String, Object>();
		
		User userEn = new User();
		userEn = modelMapper.map(body, User.class);
		userRepo.save(userEn);
		
		body.setUserId(userEn.getUserId());
		result.put("Messeage","Create User Succes" );
		result.put("Messeage", body);
		return result;
	}
	
	@GetMapping("/read")
	public Map<String, Object> read(@RequestParam(name = "id") Long id){
		Map<String, Object> result = new HashMap<String, Object>();
		
		User userEn= userRepo.findById(id).get();
		
		UserDTO userDto = new UserDTO();
		userDto = modelMapper.map(userEn, UserDTO.class);
		
		result.put("Messeage","Read Position Succes" );
		result.put("Messeage", userDto);
		return result;
	}
}
