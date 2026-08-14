package com.bidan.global.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ApiResponseTest {

    @Test
    void createSuccessResponse() {
        // given
        String code = "USER_200";
        String message = "회원 조회 성공";
        String data = "test data";

        // when
        ApiResponse<String> response =
                ApiResponse.success(
                        code,
                        message,
                        data
                );

        // then
        assertTrue(response.success());
        assertEquals(code, response.code());
        assertEquals(message, response.message());
        assertEquals(data, response.data());
    }

    @Test
    void createErrorResponse() {
        // given
        String code = "USER_NOT_FOUND";
        String message = "사용자를 찾을 수 없습니다.";

        // when
        ApiResponse<Void> response =
                ApiResponse.error(
                        code,
                        message
                );

        // then
        assertFalse(response.success());
        assertEquals(code, response.code());
        assertEquals(message, response.message());
        assertNull(response.data());
    }
}