package com.comeandeat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.comeandeat.graphql.Mutation;
import com.comeandeat.graphql.Query;
import com.comeandeat.repository.AdditionRepository;
import com.comeandeat.repository.FoodOrderMenuItemRepository;
import com.comeandeat.repository.FoodOrderRepository;
import com.comeandeat.repository.FoodProviderRepository;
import com.comeandeat.repository.MenuItemRepository;
import com.comeandeat.repository.ReviewsRepository;

@Configuration
public class GraphqlConfiguration {

	// @Bean
	// public GraphQLErrorHandler errorHandler() {
	// return new GraphQLErrorHandler() {
	// @Override
	// public List<GraphQLError> processErrors(List<GraphQLError> errors) {
	// List<GraphQLError> clientErrors = errors.stream().filter(this::isClientError)
	// .collect(Collectors.toList());
	//
	// List<GraphQLError> serverErrors = errors.stream().filter(e ->
	// !isClientError(e))
	// .map(GraphQLErrorAdapter::new).collect(Collectors.toList());
	//
	// List<GraphQLError> e = new ArrayList<>();
	// e.addAll(clientErrors);
	// e.addAll(serverErrors);
	// return e;
	// }
	//
	// protected boolean isClientError(GraphQLError error) {
	// return !(error instanceof ExceptionWhileDataFetching || error instanceof
	// Throwable);
	// }
	// };
	// }
	//
	// @Bean
	// public BookFoodOrderResolver bookResolver(FoodProviderRepository
	// foodProviderRepository) {
	// return new BookFoodOrderResolver(foodProviderRepository);
	// }

	@Bean
	public Query query(AdditionRepository additionRepository, FoodOrderMenuItemRepository foodOrderMenuItemRepository,
			FoodOrderRepository foodOrderRepository, FoodProviderRepository foodProviderRepository,
			MenuItemRepository menuItemRepository, ReviewsRepository reviewsRepository) {
		Query query = new Query();
		query.setAdditionRepository(additionRepository);
		query.setFoodOrderMenuItemRepository(foodOrderMenuItemRepository);
		query.setFoodOrderRepository(foodOrderRepository);
		query.setFoodProviderRepository(foodProviderRepository);
		query.setMenuItemRepository(menuItemRepository);
		query.setReviewsRepository(reviewsRepository);
		return query;
	}

	@Bean
	public Mutation mutation(AdditionRepository additionRepository, FoodOrderMenuItemRepository foodOrderMenuItemRepository,
			FoodOrderRepository foodOrderRepository, FoodProviderRepository foodProviderRepository,
			MenuItemRepository menuItemRepository, ReviewsRepository reviewsRepository) {
		Mutation mutation = new Mutation();
		mutation.setAdditionRepository(additionRepository);
		mutation.setFoodOrderMenuItemRepository(foodOrderMenuItemRepository);
		mutation.setFoodOrderRepository(foodOrderRepository);
		mutation.setFoodProviderRepository(foodProviderRepository);
		mutation.setMenuItemRepository(menuItemRepository);
		mutation.setReviewsRepository(reviewsRepository);

		return mutation;
	}
}