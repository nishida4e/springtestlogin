package com.example.service;

import com.example.domain.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceTest {

	@Autowired
	UserRepository userRepo;

	public List<User> findAll() {
		return userRepo.findAll();
	}

	public User findOne(String id) {
		return userRepo.findOne(id);
	}

	public User create(User user) {
		return userRepo.save(user);
	}

	public void delete(String id) {
		userRepo.delete(id);
	}
}
