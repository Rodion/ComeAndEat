package com.comeandeat;

//@Configuration
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
	
//	public Query query() {
//		Query query = new Query();
//		return query;
//	}
//
//	public Mutation mutation() {
//		Mutation mutation = new Mutation();
//		return mutation;
//	}

}