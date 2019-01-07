package com.comeandeat.service;

import java.util.ArrayList;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comeandeat.entity.Addition;
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
		return menuItemRepository.findAllByFoodProvider(foodProvider);
	}

	@Transactional
	public Iterable<Addition> findAdditionsByFoodProvider(FoodProvider foodProvider) {
		ArrayList<Addition> retVal = new ArrayList<Addition>();
		Iterable<MenuItem> menuItems = menuItemRepository.findAllByFoodProvider(foodProvider);
		for (MenuItem menuItem : menuItems) {
			if (menuItem.getAdditionsList() != null && menuItem.getAdditionsList().size() > 0) {
				retVal.addAll(menuItem.getAdditionsList());
			}
		}
		return retVal;
	}

	public MenuItem save(MenuItem menuItem) {
		return menuItemRepository.save(menuItem);
	}

	public void delete(MenuItem menuItem) {
		menuItemRepository.delete(menuItem);
	}

}
