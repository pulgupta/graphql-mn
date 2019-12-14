package com.pulgupta.demo.resolver;

import io.leangen.graphql.annotations.GraphQLQuery;

@com.pulgupta.demo.graphql.DemoResolver
public class DemoResolver {

    @GraphQLQuery(name="test", description="This query is a health check query")
    public String healthCheck() {
        return "Working!";
    }

    @GraphQLQuery(name="testexception", description="Check if exception wiring is working")
    public String ExceptionCheck() {
        throw new RuntimeException("Exception Error checks");
    }

}
