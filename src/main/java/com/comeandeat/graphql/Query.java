package com.comeandeat.graphql;

import java.util.Optional;

import com.comeandeat.entity.Addition;
import com.comeandeat.entity.FoodProvider;
import com.comeandeat.entity.MenuItem;
import com.comeandeat.entity.Reviews;
import com.comeandeat.repository.AdditionRepository;
import com.comeandeat.repository.FoodOrderMenuItemRepository;
import com.comeandeat.repository.FoodOrderRepository;
import com.comeandeat.repository.FoodProviderRepository;
import com.comeandeat.repository.MenuItemRepository;
import com.comeandeat.repository.ReviewsRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import lombok.Setter;

public class Query implements GraphQLQueryResolver {

	@Setter
	private MenuItemRepository menuItemRepository;
	@Setter
	private AdditionRepository additionRepository;
	@Setter
	private FoodOrderMenuItemRepository foodOrderMenuItemRepository;
	@Setter
	private FoodOrderRepository foodOrderRepository;
	@Setter
	private FoodProviderRepository foodProviderRepository;
	@Setter
	private ReviewsRepository reviewsRepository;

	public Query() {
	}

	// Expose all the menus of a Food Provider
	public Iterable<MenuItem> findMenuByFoodProvider(String foodProviderID) {
		Optional<FoodProvider> optional = foodProviderRepository.findById(foodProviderID);
		if (Optional.empty().equals(optional)) {
			// TODO Exception
		}
		return menuItemRepository.findMenuByFoodProvider(optional.get());
	}

	// Expose all the available additions of a Food Provider
	public Iterable<Addition> findAllAdditionsOfFoodProvider(String foodProviderID) {
		Optional<FoodProvider> optional = foodProviderRepository.findById(foodProviderID);
		if (Optional.empty().equals(optional)) {
			// TODO Exception
		}
		return foodProviderRepository.findAdditionsById(optional.get());
	}

	// List all Food Providers for a specific address.
	public Iterable<FoodProvider> findAllFoodProvidersByAddress(String address) {
		return foodProviderRepository.findAllByAddress(address);
	}

	// Filter Food Providers by Review rating
	public Iterable<Reviews> filterFoodProvidersByReview(int rating) {
		return reviewsRepository.findAllByRating(rating);
	}

}
