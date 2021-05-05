package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user != null) {

			System.out.println(user.getUsername()+user.getId()+user.getPassword()+user.getRoles());
			System.out.println(CustomUserDetails.build(user));
			CustomUserDetails users= CustomUserDetails.build(user);
			System.out.println(users.getPassword()+" "+users.getUsername()+" "+users.getAuthorities());
			return CustomUserDetails.build(user);
		} else {
			throw new UsernameNotFoundException("User not exist with name : " + username);
		}

	}

}
