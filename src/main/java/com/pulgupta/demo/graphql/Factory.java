package com.pulgupta.demo.graphql;

import com.pulgupta.demo.exception.handler.DemoDataFetcherExceptionHandler;
import graphql.GraphQL;
import graphql.execution.AsyncExecutionStrategy;
import graphql.execution.ExecutionStrategy;
import graphql.execution.preparsed.PreparsedDocumentProvider;
import io.leangen.graphql.GraphQLSchemaGenerator;
import io.micronaut.context.BeanContext;
import io.micronaut.context.annotation.Bean;
import io.micronaut.inject.qualifiers.Qualifiers;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Collection;

@io.micronaut.context.annotation.Factory
public class Factory {

    @Inject
    BeanContext beanContext;

    @Singleton
    @Bean
    public GraphQL graphQL() {
        GraphQLSchemaGenerator schemaGenerator = new GraphQLSchemaGenerator();
        schemaGenerator.withBasePackages("com.pulgupta.demo");
        Collection resolvers = this.beanContext.getBeansOfType(Object.class, Qualifiers.byStereotype(DemoResolver.class));

        for(Object resolver: resolvers) {
            Class resolverClass = resolver.getClass();
            if(resolverClass.getSimpleName().contains("$Intercepted")) {
                resolverClass = resolverClass.getSuperclass();
            }
            schemaGenerator.withOperationsFromSingleton(resolver, resolverClass);
        }

        ExecutionStrategy executionStrategy = new AsyncExecutionStrategy((new DemoDataFetcherExceptionHandler()));
        return new GraphQL.Builder(schemaGenerator.generate()).mutationExecutionStrategy(executionStrategy).queryExecutionStrategy(executionStrategy).build();
    }

}
