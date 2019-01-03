package com.comeandeat.repository;

import org.springframework.data.repository.CrudRepository;

import com.comeandeat.entity.FoodOrder;

// This will be AUTO IMPLEMENTED by Spring into a Bean called OrderRepository
// CRUD refers Create, Read, Update, Delete

public interface FoodOrderMenuItemRepository extends CrudRepository<FoodOrder, String> {

}
