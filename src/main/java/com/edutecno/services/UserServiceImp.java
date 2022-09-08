package com.edutecno.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutecno.model.Users;
import com.edutecno.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public List<Users> findAll() {		
		return userRepo.findAll();
	}
	
	public Users findByUserId(Long id) {
		return userRepo.findByUserId(id);
	}
	
	public Users findByUsername(String username) {
		return userRepo.findByUsername(username);
	}
	
	public Users findUsersByEmail(String username) {
		return userRepo.findUsersByEmail(username);
	}

	@Override
	public Users add(Users users) {
		return userRepo.save(users);
	}

	@Override
	public Users update(Users users) {		
		return userRepo.save(users);
	}

	@Override
	public void delete(Long id) {
		userRepo.deleteById(id);
	}	
}
