package com.comeandeat.service;

import java.util.Optional;

import org.javamoney.moneta.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comeandeat.entity.Addition;
import com.comeandeat.entity.FoodProvider;
import com.comeandeat.entity.Reviews;
import com.comeandeat.repository.ReviewsRepository;

@Service
public class ReviewsService {

	@Autowired
	private ReviewsRepository reviewsRepository;

	public Optional<Reviews> findById(String id) {
		return reviewsRepository.findById(id);
	}

	public Iterable<Reviews> findAllByRating(int rating) {
		return reviewsRepository.findAllByRating(rating);
	}
}
