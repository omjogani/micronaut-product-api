package co.incubyte.exception.common;

public record MicronautApiErrorResponse(String code, String message, int errorCode) {}
