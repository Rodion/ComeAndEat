package com.comeandeat.repository;

import org.springframework.data.repository.CrudRepository;

import com.comeandeat.entity.Addition;
import com.comeandeat.entity.FoodProvider;
import com.comeandeat.entity.MenuItem;

// This will be AUTO IMPLEMENTED by Spring into a Bean called OrderRepository
// CRUD refers Create, Read, Update, Delete

public interface FoodProviderRepository extends CrudRepository<FoodProvider, String> {

	public Iterable<FoodProvider> findAllByAddress(String address);

//	public Iterable<MenuItem> findMenuItemsById(FoodProvider foodProvider);
}
