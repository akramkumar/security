package com.demo.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

import com.demo.security.model.User;
import com.demo.security.repository.UserRepo;

@RestController
public class UserService {
	@Autowired
	AuthenticationManager authenticManag;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private JWTService jwtService;
	
	private BCryptPasswordEncoder encodered = new BCryptPasswordEncoder(12);
	
	public User register(User user)
	{
		user.setPassword(encodered.encode(user.getPassword()));
		return userRepo.save(user);
	}
	
	public String verify(User user)
	{
		System.out.print(user);
		Authentication authentication = authenticManag.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		if(authentication.isAuthenticated())
			return jwtService.generate(user.getUsername());
		return "fail";
	}
}
