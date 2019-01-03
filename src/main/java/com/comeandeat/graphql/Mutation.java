package com.comeandeat.graphql;

import java.util.Date;
import java.util.Optional;

import org.javamoney.moneta.Money;

import com.comeandeat.entity.FoodOrder;
import com.comeandeat.entity.FoodProvider;
import com.comeandeat.entity.MenuItem;
import com.comeandeat.repository.AdditionRepository;
import com.comeandeat.repository.FoodOrderMenuItemRepository;
import com.comeandeat.repository.FoodOrderRepository;
import com.comeandeat.repository.FoodProviderRepository;
import com.comeandeat.repository.MenuItemRepository;
import com.comeandeat.repository.ReviewsRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import lombok.Setter;

public class Mutation implements GraphQLMutationResolver {

	@Setter private MenuItemRepository menuItemRepository;
	@Setter private AdditionRepository additionRepository;
	@Setter private FoodOrderMenuItemRepository foodOrderMenuItemRepository;
	@Setter private FoodOrderRepository foodOrderRepository;
	@Setter private FoodProviderRepository foodProviderRepository;
	@Setter private ReviewsRepository reviewsRepository;

	public Mutation() {
	}

	public MenuItem newMenuItem(String foodProviderID, String description, String price) {
		MenuItem menuItem = new MenuItem();
		Optional<FoodProvider> optional = foodProviderRepository.findById(foodProviderID);
		if (Optional.empty().equals(optional)) {
			//TODO Exception
		}
		menuItem.setFoodProvider(optional.get());
		menuItem.setDescription(description);
		menuItem.setPrice(Money.parse(price));
		menuItemRepository.save(menuItem);
		return menuItem;
	}

	public FoodOrder newFoodOrder(String foodProviderName) {
		FoodOrder order = new FoodOrder();
		order.setCustomerName(foodProviderName);
		Date date = new Date();
		order.setOrderDate(date);
		foodOrderRepository.save(order);

		return order;
	}
	
	public FoodProvider newFoodProvider(String foodProviderName) {
		FoodProvider foodProvider = new FoodProvider();
		foodProvider.setAddress("asdasd");
		foodProvider.setContactName("asdasd");
		foodProvider.setContactNumber("asdasd");
		foodProvider.setDeliveryPrice(Money.parse("12USD"));
		foodProvider.setFoodProviderName(foodProviderName);
		foodProvider.setWorkingHours("asd");
		foodProviderRepository.save(foodProvider);
		return foodProvider;
	}
	
}