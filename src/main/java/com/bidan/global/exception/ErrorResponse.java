package com.bidan.global.exception;

public record ErrorResponse(
        String code,
        String message
) {
}