package co.incubyte.exception.handler;

import co.incubyte.exception.EntityNotFound;
import co.incubyte.exception.ValidationFailedException;
import co.incubyte.exception.common.MicronautApiErrorResponse;
import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;

@Singleton
@Produces
@Requires(classes = {EntityNotFound.class, ExceptionHandler.class})
public class ValidationFailedExceptionHandler implements ExceptionHandler<ValidationFailedException, HttpResponse<MicronautApiErrorResponse>> {

    @Override
    public HttpResponse<MicronautApiErrorResponse> handle(HttpRequest request, ValidationFailedException exception) {
        return HttpResponse.badRequest(new MicronautApiErrorResponse("VALIDATION_FAILED", exception.getMessage(), HttpStatus.NOT_FOUND.getCode()));
    }
}
