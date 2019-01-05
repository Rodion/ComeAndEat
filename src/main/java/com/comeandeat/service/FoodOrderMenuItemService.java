package com.comeandeat.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comeandeat.entity.Addition;
import com.comeandeat.entity.OrderMenuItem;
import com.comeandeat.repository.FoodOrderMenuItemRepository;

@Service
public class FoodOrderMenuItemService {

	@Autowired
	private FoodOrderMenuItemRepository foodOrderMenuItemRepository;

	public Optional<OrderMenuItem> findById(String id) {
		return foodOrderMenuItemRepository.findById(id);
	}

	public OrderMenuItem save(OrderMenuItem orderMenuItem) {
		return foodOrderMenuItemRepository.save(orderMenuItem);
	}

}
