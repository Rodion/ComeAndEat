package com.comeandeat.repository;

import org.springframework.data.repository.CrudRepository;

import com.comeandeat.entity.FoodProvider;
import com.comeandeat.entity.MenuItem;

// This will be AUTO IMPLEMENTED by Spring into a Bean called OrderRepository
// CRUD refers Create, Read, Update, Delete

public interface MenuItemRepository extends CrudRepository<MenuItem, String> {

	//@Query "select a from MenuItem a where"
	public Iterable<MenuItem> findMenuByFoodProvider(FoodProvider foodProvider);
}
