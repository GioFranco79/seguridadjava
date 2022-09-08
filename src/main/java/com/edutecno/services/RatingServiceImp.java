package com.edutecno.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutecno.model.Rating;
import com.edutecno.repository.RatingRepository;

@Service
public class RatingServiceImp implements RatingService {
	@Autowired
	private RatingRepository ratingRepo;
	
	@Override
	public List<Rating> findAll() {
		return ratingRepo.findAll();
	}

	public List<Rating> findAllShows(Long id) {
		return ratingRepo.findAllShows(id);
	}	
	
	@Override
	public Rating add(Rating rating) {
		return ratingRepo.save(rating);
	}

	@Override
	public Rating update(Rating rating) {		
		return ratingRepo.save(rating);
	}

	@Override
	public void delete(Long id) {
		ratingRepo.deleteById(id);	
	}

}
