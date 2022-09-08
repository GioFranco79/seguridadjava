package com.edutecno.services;

import java.util.List;

import com.edutecno.model.Rating;

public interface RatingService {
	public List<Rating> findAll();
	public List<Rating> findAllShows(Long id);
	public Rating add(Rating rating);
	public Rating update(Rating rating);
	public void delete(Long id);			
}
