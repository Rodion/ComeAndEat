package com.comeandeat.graphql;

import java.util.Date;
import java.util.Optional;

import org.javamoney.moneta.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comeandeat.entity.FoodOrder;
import com.comeandeat.entity.FoodProvider;
import com.comeandeat.entity.MenuItem;
import com.comeandeat.service.AdditionService;
import com.comeandeat.service.FoodOrderMenuItemService;
import com.comeandeat.service.FoodOrderService;
import com.comeandeat.service.FoodProviderService;
import com.comeandeat.service.MenuItemService;
import com.comeandeat.service.ReviewsService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

@Component
public class Mutation implements GraphQLMutationResolver {

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
	public Mutation() {
	}

	public MenuItem newMenuItem(String foodProviderID, String description, String price) {

		Optional<FoodProvider> optional = foodProviderService.findById(foodProviderID);
		if (Optional.empty().equals(optional)) {
			// TODO Exception
		}

		MenuItem menuItem = new MenuItem();
		menuItem.setFoodProvider(optional.get());
		menuItem.setDescription(description);
		menuItem.setPrice(Money.parse(price));
		menuItemService.save(menuItem);
		return menuItem;
	}

	public FoodOrder newFoodOrder(String foodProviderName) {
		FoodOrder order = new FoodOrder();
		order.setCustomerName(foodProviderName);
		Date date = new Date();
		order.setOrderDate(date);
		foodOrderService.save(order);

		return order;
	}

	public FoodProvider newFoodProvider(String foodProviderName, String address, String contactName,
			String contactNumber, String deliveryPrice, String workingHours) {
		return foodProviderService.newFoodProvider(foodProviderName, address, contactName, contactNumber, deliveryPrice,
				workingHours);
	}

}