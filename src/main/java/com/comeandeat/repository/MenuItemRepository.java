package com.comeandeat.repository;

import org.springframework.data.repository.CrudRepository;

import com.comeandeat.entity.FoodProvider;
import com.comeandeat.entity.MenuItem;

// This will be AUTO IMPLEMENTED by Spring into a Bean called OrderRepository
// CRUD refers Create, Read, Update, Delete

public interface MenuItemRepository extends CrudRepository<MenuItem, String> {

	// @Query("SELECT * FROM addition a, menu_item b where a.menu_item_id=b.id and
	// food_provider_id=?1")
	// public Iterable<MenuItem> findAllByFoodProvider(String menuItemId);
	public Iterable<MenuItem> findAllByFoodProvider(FoodProvider foodProvider);
}
