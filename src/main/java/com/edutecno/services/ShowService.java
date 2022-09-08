package com.edutecno.services;

import java.util.List;
import java.util.Optional;

import com.edutecno.model.Show;

public interface ShowService {
	public List<Show> findAll();
	public Optional<Show> findById(Long id);	
	public Show add(Show show);
	public Show update(Show show);
	public void delete(Long id);		
}
