package com.comeandeat.service;

import java.util.Optional;

import org.javamoney.moneta.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comeandeat.entity.Addition;
import com.comeandeat.entity.FoodProvider;
import com.comeandeat.repository.AdditionRepository;

@Service
public class AdditionService {

	@Autowired
	private AdditionRepository additionRepository;

	public Optional<Addition> findById(String id) {
		return additionRepository.findById(id);
	}
	
	public Addition save(Addition addition) {
		return additionRepository.save(addition);
	}

}