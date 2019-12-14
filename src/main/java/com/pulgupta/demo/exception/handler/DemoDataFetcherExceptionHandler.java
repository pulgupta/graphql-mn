package com.pulgupta.demo.exception.handler;

import graphql.ExceptionWhileDataFetching;
import graphql.execution.DataFetcherExceptionHandler;
import graphql.execution.DataFetcherExceptionHandlerParameters;
import graphql.execution.DataFetcherExceptionHandlerResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoDataFetcherExceptionHandler implements DataFetcherExceptionHandler {
    Logger logger = LoggerFactory.getLogger(DemoDataFetcherExceptionHandler.class);

    @Override
    public DataFetcherExceptionHandlerResult onException(DataFetcherExceptionHandlerParameters handlerParameters) {
        logger.error("Exception handling is also working {}", handlerParameters.getException().getMessage());
        ExceptionWhileDataFetching error = new ExceptionWhileDataFetching(handlerParameters.getPath(), handlerParameters.getException(), handlerParameters.getSourceLocation());
        return DataFetcherExceptionHandlerResult.newResult().error(error).build();
    }
}
