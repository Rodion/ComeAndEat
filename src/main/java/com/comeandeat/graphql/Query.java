package com.comeandeat.graphql;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comeandeat.entity.Addition;
import com.comeandeat.entity.FoodProvider;
import com.comeandeat.entity.MenuItem;
import com.comeandeat.entity.Reviews;
import com.comeandeat.service.AdditionService;
import com.comeandeat.service.FoodOrderMenuItemService;
import com.comeandeat.service.FoodOrderService;
import com.comeandeat.service.FoodProviderService;
import com.comeandeat.service.MenuItemService;
import com.comeandeat.service.ReviewsService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class Query implements GraphQLQueryResolver {

	@Autowired
	private MenuItemService menuItemService;
	@Autowired
	private AdditionService additionService;
	@Autowired
	private FoodOrderMenuItemService foodOrderMenuItemService;
	@Autowired
	private FoodOrderService foodOrderService;
	@Autowired
	private FoodProviderService foodProviderService;
	@Autowired
	private ReviewsService reviewsService;

	@Autowired
	public Query() {
	}

	// Expose all the menus of a Food Provider
	public Iterable<MenuItem> findMenuByFoodProvider(String foodProviderID) {
		Optional<FoodProvider> optional = foodProviderService.findById(foodProviderID);
		if (Optional.empty().equals(optional)) {
			// TODO Exception
		}
		return menuItemService.findMenuByFoodProvider(optional.get());
	}

	// Expose all the available additions of a Food Provider
	public Iterable<Addition> findAllAdditionsOfFoodProvider(String foodProviderID) {
		Optional<FoodProvider> optional = foodProviderService.findById(foodProviderID);
		if (Optional.empty().equals(optional)) {
			// TODO Exception
		}
		return foodProviderService.findAdditionsById(optional.get());
	}

	// List all Food Providers for a specific address.
	public Iterable<FoodProvider> findAllFoodProvidersByAddress(String address) {
		return foodProviderService.findAllByAddress(address);
	}

	// Filter Food Providers by Review rating
	public Iterable<Reviews> filterFoodProvidersByReview(int rating) {
		return reviewsService.findAllByRating(rating);
	}

}
