package com.comeandeat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.comeandeat.entity.Reviews;

// This will be AUTO IMPLEMENTED by Spring into a Bean called OrderRepository
// CRUD refers Create, Read, Update, Delete

public interface ReviewsRepository extends CrudRepository<Reviews, String> {

	public Iterable<Reviews> findAllByRating(int rating);

	@Query("SELECT foodProvider, avg(u.rating) from Reviews u group by foodProvider  order by rating")
	public List<Reviews> sortFoodProvidersByAverageRating();
}
