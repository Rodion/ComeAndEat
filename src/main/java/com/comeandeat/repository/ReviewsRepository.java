package com.comeandeat.repository;

import org.springframework.data.repository.CrudRepository;

import com.comeandeat.entity.FoodOrder;
import com.comeandeat.entity.FoodProvider;
import com.comeandeat.entity.Reviews;

// This will be AUTO IMPLEMENTED by Spring into a Bean called OrderRepository
// CRUD refers Create, Read, Update, Delete

public interface ReviewsRepository extends CrudRepository<Reviews, String> {

	public Iterable<Reviews> findAllByRating(int rating);

}
