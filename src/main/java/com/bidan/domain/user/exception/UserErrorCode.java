package com.bidan.domain.user.exception;

import com.bidan.global.exception.ErrorCode;
import org.springframework.http.HttpStatus;

public enum UserErrorCode implements ErrorCode {

    USER_NOT_FOUND(
            HttpStatus.NOT_FOUND,
            "사용자를 찾을 수 없습니다."
    ),

    USER_ALREADY_EXISTS(
            HttpStatus.CONFLICT,
            "이미 존재하는 사용자입니다."
    ),

    INVALID_PASSWORD(
            HttpStatus.BAD_REQUEST,
            "비밀번호가 올바르지 않습니다."
    );

    private final HttpStatus status;
    private final String message;

    UserErrorCode(
            HttpStatus status,
            String message
    ) {
        this.status = status;
        this.message = message;
    }

    @Override
    public String getCode() {
        return name();
    }

    @Override
    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}