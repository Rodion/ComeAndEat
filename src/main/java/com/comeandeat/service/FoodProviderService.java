package com.comeandeat.service;

import java.util.Optional;

import org.javamoney.moneta.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comeandeat.entity.FoodProvider;
import com.comeandeat.repository.FoodProviderRepository;

@Service
public class FoodProviderService {

	@Autowired
	private FoodProviderRepository foodProviderRepository;

	// public Iterable<MenuItem> findMenuItemsByFoodProvider(FoodProvider
	// foodProvider) {
	// return foodProviderRepository.findMenuItemsById(foodProvider);
	// }

	public Iterable<FoodProvider> findAllByAddress(String address) {
		return foodProviderRepository.findAllByAddress(address);
	}

	public Optional<FoodProvider> findById(String id) {
		return foodProviderRepository.findById(id);
	}

	public FoodProvider newFoodProvider(String foodProviderName, String address, String contactName,
			String contactNumber, String deliveryPrice, String workingHours) {
		FoodProvider foodProvider = new FoodProvider();
		foodProvider.setFoodProviderName(foodProviderName);
		foodProvider.setAddress(address);
		foodProvider.setContactName(contactName);
		foodProvider.setContactNumber(contactNumber);
		Money price = Money.parse("USD 5");
		try {
			price = Money.parse(deliveryPrice);
		} catch (Exception e) {
			// TODO Exception
		}
		foodProvider.setDeliveryPrice(price); // "USD 5"
		foodProvider.setWorkingHours(workingHours);
		foodProviderRepository.save(foodProvider);
		return foodProvider;
	}

	public FoodProvider save(FoodProvider foodProvider) {
		return foodProviderRepository.save(foodProvider);
	}

	public void delete(FoodProvider foodProvider) {
		foodProviderRepository.delete(foodProvider);
	}

}
