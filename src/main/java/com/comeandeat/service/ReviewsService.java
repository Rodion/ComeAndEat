package com.comeandeat.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.comeandeat.entity.Reviews;
import com.comeandeat.repository.ReviewsRepository;

@Service
public class ReviewsService {

	@Autowired
	private ReviewsRepository reviewsRepository;

	public Optional<Reviews> findById(String id) {
		return reviewsRepository.findById(id);
	}

	public Iterable<Reviews> sortFoodProvidersByAverageRating() {
		return reviewsRepository.sortFoodProvidersByAverageRating();
	}

	public Iterable<Reviews> findAllByRating(int rating) {
		return reviewsRepository.findAllByRating(rating);
	}
	
	public Reviews save(Reviews reviews) {
		return reviewsRepository.save(reviews);
	}
	
	public void delete(Reviews reviews) {
		reviewsRepository.delete(reviews);
	}

}
