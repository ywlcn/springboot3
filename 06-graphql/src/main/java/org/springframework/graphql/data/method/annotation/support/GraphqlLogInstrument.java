package org.springframework.graphql.data.method.annotation.support;

import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.execution.ExecutionContext;
import graphql.execution.instrumentation.*;
import graphql.execution.instrumentation.parameters.*;
import graphql.language.Document;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLSchema;
import graphql.schema.PropertyDataFetcher;
import graphql.validation.ValidationError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.util.List;
import java.util.concurrent.CompletableFuture;


// AnnotatedControllerConfigurer.BatchMappingDataFetcher をアクセスできるため

public class GraphqlLogInstrument implements Instrumentation , Ordered {

    private final Logger logger = LoggerFactory.getLogger(GraphqlLogInstrument.class);

    int order = -1;

    public GraphqlLogInstrument(int order){
        this.order = order;
    }

    @Override
    public InstrumentationState createState(InstrumentationCreateStateParameters parameters) {
        logger.warn("GraphqlLogInstrument[" + order + "]--->createState");
        return Instrumentation.super.createState(parameters);
    }

    @Override
    public InstrumentationContext<ExecutionResult> beginExecution(InstrumentationExecutionParameters parameters, InstrumentationState state) {

        logger.warn("GraphqlLogInstrument[" + order + "]--->beginExecution");
        return Instrumentation.super.beginExecution(parameters, state);
    }

    @Override
    public InstrumentationContext<Document> beginParse(InstrumentationExecutionParameters parameters, InstrumentationState state) {
        logger.warn("GraphqlLogInstrument[" + order + "]--->beginParse");
        return Instrumentation.super.beginParse(parameters, state);
    }

    @Override
    public InstrumentationContext<List<ValidationError>> beginValidation(InstrumentationValidationParameters parameters, InstrumentationState state) {
        logger.warn("GraphqlLogInstrument[" + order + "]--->beginValidation");
        return Instrumentation.super.beginValidation(parameters, state);
    }

    @Override
    public InstrumentationContext<ExecutionResult> beginExecuteOperation(InstrumentationExecuteOperationParameters parameters, InstrumentationState state) {
        return Instrumentation.super.beginExecuteOperation(parameters, state);
    }

    @Override
    public ExecutionStrategyInstrumentationContext beginExecutionStrategy(InstrumentationExecutionStrategyParameters parameters, InstrumentationState state) {
        return Instrumentation.super.beginExecutionStrategy(parameters, state);
    }

    @Override
    public InstrumentationContext<ExecutionResult> beginSubscribedFieldEvent(InstrumentationFieldParameters parameters, InstrumentationState state) {
        return Instrumentation.super.beginSubscribedFieldEvent(parameters, state);
    }

    @Override
    public InstrumentationContext<ExecutionResult> beginField(InstrumentationFieldParameters parameters, InstrumentationState state) {
        return Instrumentation.super.beginField(parameters, state);
    }

    @Override
    public InstrumentationContext<Object> beginFieldFetch(InstrumentationFieldFetchParameters parameters, InstrumentationState state) {
        return Instrumentation.super.beginFieldFetch(parameters, state);
    }

    @Override
    public InstrumentationContext<ExecutionResult> beginFieldComplete(InstrumentationFieldCompleteParameters parameters, InstrumentationState state) {
        return Instrumentation.super.beginFieldComplete(parameters, state);
    }

    @Override
    public InstrumentationContext<ExecutionResult> beginFieldListComplete(InstrumentationFieldCompleteParameters parameters, InstrumentationState state) {
        return Instrumentation.super.beginFieldListComplete(parameters, state);
    }

    @Override
    public ExecutionInput instrumentExecutionInput(ExecutionInput executionInput, InstrumentationExecutionParameters parameters, InstrumentationState state) {
        return Instrumentation.super.instrumentExecutionInput(executionInput, parameters, state);
    }

    @Override
    public DocumentAndVariables instrumentDocumentAndVariables(DocumentAndVariables documentAndVariables, InstrumentationExecutionParameters parameters, InstrumentationState state) {
        return Instrumentation.super.instrumentDocumentAndVariables(documentAndVariables, parameters, state);
    }

    @Override
    public GraphQLSchema instrumentSchema(GraphQLSchema schema, InstrumentationExecutionParameters parameters, InstrumentationState state) {
        return Instrumentation.super.instrumentSchema(schema, parameters, state);
    }

    @Override
    public ExecutionContext instrumentExecutionContext(ExecutionContext executionContext, InstrumentationExecutionParameters parameters, InstrumentationState state) {
        logger.warn("GraphqlLogInstrument[" + order + "]--->instrumentExecutionContext");
        return Instrumentation.super.instrumentExecutionContext(executionContext, parameters, state);
    }

    @Override
    public DataFetcher<?> instrumentDataFetcher(DataFetcher<?> dataFetcher, InstrumentationFieldFetchParameters parameters, InstrumentationState state) {

        if (dataFetcher instanceof PropertyDataFetcher propertyDataFetcher) {
            logger.warn("GraphqlLogInstrument[" + order + "]--->instrumentDataFetcher {}--{}", "PropertyDataFetcher", propertyDataFetcher.getPropertyName());
        } else if (dataFetcher instanceof AnnotatedControllerConfigurer.BatchMappingDataFetcher propertyDataFetcher) {
            logger.warn("GraphqlLogInstrument[" + order + "]--->instrumentDataFetcher {}--{}", "BatchMappingDataFetcher", propertyDataFetcher.getDescription());
        } else {
            logger.warn("GraphqlLogInstrument[" + order + "]--->instrumentDataFetcher {}--{}", "Other", dataFetcher);
        }
        return Instrumentation.super.instrumentDataFetcher(dataFetcher, parameters, state);
    }

    @Override
    public CompletableFuture<ExecutionResult> instrumentExecutionResult(ExecutionResult executionResult, InstrumentationExecutionParameters parameters, InstrumentationState state) {
        logger.warn("GraphqlLogInstrument[" + order + "]--->instrumentExecutionResult");
        return Instrumentation.super.instrumentExecutionResult(executionResult, parameters, state);
    }

    @Override
    public int getOrder() {
        return order;
    }
}
