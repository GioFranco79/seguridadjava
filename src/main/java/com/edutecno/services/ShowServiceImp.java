package com.edutecno.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutecno.model.Show;
import com.edutecno.repository.ShowRepository;

@Service
public class ShowServiceImp implements ShowService {
	@Autowired
	private ShowRepository showRepo;
	
	@Override
	public List<Show> findAll() {
		return showRepo.findAll();
	}

	@Override
	public Optional<Show> findById(Long id) {
		return showRepo.findById(id); 
	}
	
	@Override
	public Show add(Show show) {
		return showRepo.save(show);
	}

	@Override
	public Show update(Show show) {
		return showRepo.save(show);
	}

	@Override
	public void delete(Long id) {
		showRepo.deleteById(id);
	}

}
