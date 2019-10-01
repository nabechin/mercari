package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.User;
import com.example.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	public User findByEmail(String email) {
		return repository.findByEmail(email);
	}
	public void insert(User user) {
		String encoder = passwordEncoder.encode(user.getPassword());
		user.setPassword(encoder);
		repository.insert(user);
	}
}
