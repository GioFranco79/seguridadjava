package com.edutecno.services;

import java.util.List;

import com.edutecno.model.Users;

public interface UserService {
	public List<Users> findAll();
	public Users findUsersByEmail(String username); 
	public Users findByUsername(String username);
	public Users add(Users users);
	public Users update(Users users);
	public void delete(Long id);
	public Users findByUserId(Long id);			
}
