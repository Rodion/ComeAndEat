package com.comeandeat;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.commons.collections4.IterableUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javamoney.moneta.Money;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.comeandeat.entity.Addition;
import com.comeandeat.entity.FoodOrder;
import com.comeandeat.entity.FoodProvider;
import com.comeandeat.entity.MenuItem;
import com.comeandeat.entity.OrderMenuItem;
import com.comeandeat.entity.Reviews;
import com.comeandeat.service.AdditionService;
import com.comeandeat.service.FoodOrderMenuItemService;
import com.comeandeat.service.FoodOrderService;
import com.comeandeat.service.FoodProviderService;
import com.comeandeat.service.MenuItemService;
import com.comeandeat.service.ReviewsService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ComeandeatServiceTest {
	

 
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
	private static final Logger logger = LogManager.getLogger(SpringApplication.class);

	@Test
	public void testSuite() {
		String address = "TA";
		logger.info(" ====== Start Testing =========== ");

		FoodProvider foodProvider1 = createFoodProvider("JUnitTest1", address);
		FoodProvider foodProvider2 = createFoodProvider("JUnitTest2", address);
		MenuItem menuItem1FP1 = createMenuItem(foodProvider1, "menu item 1", Money.parse("USD 1"));
		MenuItem menuItem2FP1 = createMenuItem(foodProvider1, "menu item 2", Money.parse("USD 2"));
		MenuItem menuItem3FP1 = createMenuItem(foodProvider1, "menu item 3", Money.parse("GBP 3"));
		MenuItem menuItem1FP2 = createMenuItem(foodProvider2, "menu item 1", Money.parse("EUR 5"));
		MenuItem menuItem2FP2 = createMenuItem(foodProvider2, "menu item 2", Money.parse("USD 5"));
		MenuItem menuItem3FP2 = createMenuItem(foodProvider2, "menu item 3", Money.parse("JPY 100"));
		Addition additionMI1FP1 = createAddition(menuItem1FP1, "addition 1", Money.parse("USD 1"));
		Addition additionMI2FP1 = createAddition(menuItem1FP1, "addition 2", Money.parse("USD 2"));
		Addition additionMI3FP1 = createAddition(menuItem1FP1, "addition 2", Money.parse("USD 1"));
		Addition additionMI1FP2 = createAddition(menuItem1FP2, "addition 2", Money.parse("USD 2"));
		Addition additionMI2FP2 = createAddition(menuItem1FP2, "addition 2", Money.parse("USD 1"));
		Addition additionMI3FP2 = createAddition(menuItem1FP2, "addition 2", Money.parse("USD 2"));
		FoodOrder foodOrder1FP1 = createFoodOrder(foodProvider1, "Customer 1");
		FoodOrder foodOrder2FP1 = createFoodOrder(foodProvider1, "Customer 2");
		FoodOrder foodOrder1FP2 = createFoodOrder(foodProvider1, "Customer 3");
		FoodOrder foodOrder2FP2 = createFoodOrder(foodProvider1, "Customer 4");
		OrderMenuItem orderMenuItem1 = createOrderMenuItem(foodProvider1, menuItem1FP1, foodOrder1FP1, additionMI1FP1);
		OrderMenuItem orderMenuItem2 = createOrderMenuItem(foodProvider1, menuItem1FP1, foodOrder1FP1, additionMI1FP1);
		OrderMenuItem orderMenuItem3 = createOrderMenuItem(foodProvider1, menuItem1FP1, foodOrder1FP1, additionMI1FP1);
		OrderMenuItem orderMenuItem4 = createOrderMenuItem(foodProvider1, menuItem1FP1, foodOrder1FP1, additionMI1FP1);
		Reviews review1FP1 = createReview(foodProvider1, 1, "sdfaf");
		Reviews review2FP1 = createReview(foodProvider1, 2, "sdfaf");
		Reviews review3FP1 = createReview(foodProvider1, 2, "sdfaf");
		Reviews review4FP1 = createReview(foodProvider1, 3, "sdfaf");
		Reviews review5FP1 = createReview(foodProvider1, 3, "sdfaf");

		Reviews review1FP2 = createReview(foodProvider2, 1, "sdfaf");
		Reviews review2FP2 = createReview(foodProvider2, 1, "sdfaf");
		Reviews review3FP2 = createReview(foodProvider2, 3, "sdfaf");
		Reviews review4FP2 = createReview(foodProvider2, 3, "sdfaf");
		Reviews review5FP2 = createReview(foodProvider2, 3, "sdfaf");

		try {
			// Expose all the menus of a Food Provider
			Iterable<MenuItem> foodProviderMenu = menuItemService.findMenuByFoodProvider(foodProvider1);

			assertTrue(IterableUtils.size(foodProviderMenu) == 3);

			foodProviderMenu = menuItemService.findMenuByFoodProvider(foodProvider2);
			assertTrue(IterableUtils.size(foodProviderMenu) == 3);

			// Expose all the available additions of a Food Provider
			Iterable<Addition> additions = menuItemService.findAdditionsByFoodProvider(foodProvider1);
			assertTrue(IterableUtils.size(additions) == 3);

			additions = menuItemService.findAdditionsByFoodProvider(foodProvider2);
			assertTrue(IterableUtils.size(additions) == 3);

			// List all Food Providers for a specific address.
			Iterable<FoodProvider> foodProvider = foodProviderService.findAllByAddress(address);
			// assertTrue(IterableUtils.size(foodProvider)==2);

			// Filter Food Providers by Review rating
			Iterable<Reviews> reviews = reviewsService.sortFoodProvidersByAverageRating();
			assertTrue(IterableUtils.size(reviews) > 1);
		} catch (Exception e) {

		} finally {

			reviewsService.delete(review1FP1);
			reviewsService.delete(review2FP1);
			reviewsService.delete(review3FP1);
			reviewsService.delete(review4FP1);
			reviewsService.delete(review5FP1);
			reviewsService.delete(review1FP2);
			reviewsService.delete(review2FP2);
			reviewsService.delete(review3FP2);
			reviewsService.delete(review4FP2);
			reviewsService.delete(review5FP2);

			foodOrderMenuItemService.delete(orderMenuItem1);
			foodOrderMenuItemService.delete(orderMenuItem2);
			foodOrderMenuItemService.delete(orderMenuItem3);
			foodOrderMenuItemService.delete(orderMenuItem4);
			foodOrderService.delete(foodOrder1FP1);
			foodOrderService.delete(foodOrder2FP1);
			foodOrderService.delete(foodOrder1FP2);
			foodOrderService.delete(foodOrder2FP2);
			additionService.delete(additionMI1FP1);
			additionService.delete(additionMI2FP1);
			additionService.delete(additionMI3FP1);
			additionService.delete(additionMI1FP2);
			additionService.delete(additionMI2FP2);
			additionService.delete(additionMI3FP2);
			menuItemService.delete(menuItem1FP1);
			menuItemService.delete(menuItem2FP1);
			menuItemService.delete(menuItem3FP1);
			menuItemService.delete(menuItem1FP2);
			menuItemService.delete(menuItem2FP2);
			menuItemService.delete(menuItem3FP2);
			foodProviderService.delete(foodProvider1);
			foodProviderService.delete(foodProvider2);
		}
	}

	private FoodProvider createFoodProvider(String name, String address) {
		FoodProvider foodProvider = new FoodProvider();
		foodProvider.setFoodProviderName(name);
		foodProvider.setAddress(address);
		Money price = Money.parse("USD 5");
		foodProvider.setDeliveryPrice(price); // "USD 5"
		foodProvider = foodProviderService.save(foodProvider);
		assertNotNull("Unit Test :: create food provider failed.", foodProvider.getId());
		return foodProvider;
	}

	private MenuItem createMenuItem(FoodProvider foodProvider, String description, Money price) {
		MenuItem menuItem = new MenuItem();
		menuItem.setFoodProvider(foodProvider);
		menuItem.setDescription(description);
		menuItem.setPrice(price);
		menuItem = menuItemService.save(menuItem);
		assertNotNull("Unit Test :: create food provider failed.", menuItem.getId());
		return menuItem;
	}

	private Addition createAddition(MenuItem menuItem, String additionName, Money price) {
		Addition addition = new Addition();
		addition.setAdditionName(additionName);
		addition.setMenuItem(menuItem);
		addition.setPrice(price);
		addition = additionService.save(addition);
		assertNotNull("Unit Test :: create food provider failed.", addition.getId());
		return addition;
	}

	private FoodOrder createFoodOrder(FoodProvider foodProvider, String customerName) {
		FoodOrder foodOrder = new FoodOrder();
		foodOrder.setFoodProvider(foodProvider);
		foodOrder.setCustomerName(customerName);
		foodOrderService.save(foodOrder);
		assertNotNull("Unit Test :: create order failed.", foodOrder.getId());
		return foodOrder;
	}

	private OrderMenuItem createOrderMenuItem(FoodProvider foodProvider, MenuItem menuItem, FoodOrder foodOrder,
			Addition addition) {
		OrderMenuItem orderMenuItem = new OrderMenuItem();
		orderMenuItem.setFoodProvider(foodProvider);
		orderMenuItem.setMenuItem(menuItem);
		orderMenuItem.setOrder(foodOrder);
		orderMenuItem.setAddition(addition);
		foodOrderMenuItemService.save(orderMenuItem);
		assertNotNull("Unit Test :: create orderMenuItem failed.", orderMenuItem.getId());
		return orderMenuItem;
	}

	private Reviews createReview(FoodProvider foodProvider, int rating, String reviewText) {
		Reviews review = new Reviews();
		review.setFoodProvider(foodProvider);
		review.setRating(rating);
		review.setReviewText(reviewText);
		reviewsService.save(review);
		assertNotNull("Unit Test :: create review failed.", review.getId());
		return review;
	}
}
