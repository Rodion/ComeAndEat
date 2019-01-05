package com.comeandeat.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comeandeat.entity.FoodProvider;
import com.comeandeat.entity.MenuItem;
import com.comeandeat.repository.MenuItemRepository;

@Service
public class MenuItemService {

	@Autowired
	private MenuItemRepository menuItemRepository;

	public Optional<MenuItem> findById(String id) {
		return menuItemRepository.findById(id);
	}

	public Iterable<MenuItem> findMenuByFoodProvider(FoodProvider foodProvider) {
		return menuItemRepository.findMenuByFoodProvider(foodProvider);
	}

	public MenuItem save(MenuItem menuItem) {
		return menuItemRepository.save(menuItem);
	}

}
