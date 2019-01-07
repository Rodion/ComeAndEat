package com.comeandeat.resolver;

import java.awt.print.Book;

import com.comeandeat.repository.FoodProviderRepository;
import com.coxautodev.graphql.tools.GraphQLResolver;

public class BookFoodOrderResolver implements GraphQLResolver<Book> {

	private FoodProviderRepository foodProviderRepository;

	public BookFoodOrderResolver(FoodProviderRepository foodProviderRepository) {
		this.foodProviderRepository = foodProviderRepository;
	}

}