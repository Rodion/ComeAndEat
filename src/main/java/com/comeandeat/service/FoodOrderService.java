package com.comeandeat.service;

import java.util.Optional;

import org.javamoney.moneta.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comeandeat.entity.Addition;
import com.comeandeat.entity.FoodOrder;
import com.comeandeat.entity.FoodProvider;
import com.comeandeat.entity.OrderMenuItem;
import com.comeandeat.repository.FoodOrderRepository;

@Service
public class FoodOrderService {

	@Autowired
	private FoodOrderRepository foodOrderRepository;

	public Optional<FoodOrder> findById(String id) {
		return foodOrderRepository.findById(id);
	}

	public FoodOrder save(FoodOrder foodOrder) {
		return foodOrderRepository.save(foodOrder);
	}

	public void delete(FoodOrder foodOrder) {
		foodOrderRepository.delete(foodOrder);
	}

}
