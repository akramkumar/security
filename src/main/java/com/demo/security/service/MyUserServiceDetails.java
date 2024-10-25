package com.demo.security.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.security.model.User;
import com.demo.security.model.UserPrinciple;
import com.demo.security.repository.UserRepo;

@Service
public class MyUserServiceDetails implements UserDetailsService{
	@Autowired
	private UserRepo userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user =userRepo.findByUsername(username);
		if(user == null)
		{
			throw new UsernameNotFoundException("The username "+username+" is not found");
		}
		return new UserPrinciple(user);
	}

}
