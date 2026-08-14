package com.bidan.global.exception;

import com.bidan.domain.user.exception.UserErrorCode;
import com.bidan.domain.user.exception.UserException;
import com.bidan.global.response.ApiResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler handler =
            new GlobalExceptionHandler();

    @Test
    void handleBusinessException() {
        // given
        UserException exception =
                new UserException(
                        UserErrorCode.USER_NOT_FOUND
                );

        // when
        ResponseEntity<ApiResponse<Void>> response =
                handler.handleBusinessException(exception);

        // then
        assertEquals(
                HttpStatus.NOT_FOUND,
                response.getStatusCode()
        );

        ApiResponse<Void> body = response.getBody();

        assertNotNull(body);
        assertFalse(body.success());
        assertEquals(
                "USER_NOT_FOUND",
                body.code()
        );
        assertEquals(
                "사용자를 찾을 수 없습니다.",
                body.message()
        );
        assertNull(body.data());
    }
}