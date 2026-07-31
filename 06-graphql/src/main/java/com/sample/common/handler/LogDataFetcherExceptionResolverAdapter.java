package com.sample.common.handler;

import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import graphql.GraphQLError;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.graphql.execution.ErrorType;

import java.util.List;

public class LogDataFetcherExceptionResolverAdapter extends DataFetcherExceptionResolverAdapter {

    @Override
    protected List<GraphQLError> resolveToMultipleErrors(Throwable ex, DataFetchingEnvironment env) {
        return super.resolveToMultipleErrors(ex, env);
    }

    @Override
    protected GraphQLError resolveToSingleError(Throwable e, DataFetchingEnvironment env) {

        if (e instanceof RuntimeJsonMappingException) {
            return GraphQLError.newError().message(e.getMessage()).errorType(ErrorType.FORBIDDEN).build();
        }
        return GraphQLError.newError().message(e.getMessage()).errorType(ErrorType.INTERNAL_ERROR).build();

    }
}
