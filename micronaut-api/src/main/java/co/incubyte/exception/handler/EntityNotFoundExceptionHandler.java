package co.incubyte.exception.handler;


import co.incubyte.exception.EntityNotFound;
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
public class EntityNotFoundExceptionHandler implements ExceptionHandler<EntityNotFound, HttpResponse<MicronautApiErrorResponse>> {

    @Override
    public HttpResponse<MicronautApiErrorResponse> handle(HttpRequest request, EntityNotFound exception) {
        return HttpResponse.notFound(new MicronautApiErrorResponse("ENTITY_NOT_FOUND", exception.getMessage(), HttpStatus.NOT_FOUND.getCode()));
    }
}
