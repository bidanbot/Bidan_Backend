package com.bidan.global.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.bidan.global.response.ApiResponse;
/* Exception 예외 발생 시 Handler를 통해 비즈니스 예외,
Checked Exception를 인식하여 아래 방식으로 처리
이때 BusinessException은 unchecked Exception 관련 예외 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiResponse<Void>> handleBusinessException(
            BusinessException e
    ) {

        ErrorCode errorCode = e.getErrorCode();

        ApiResponse<Void> response = ApiResponse.error(
                errorCode.getCode(),
                errorCode.getMessage()
        );

        return ResponseEntity
                .status(errorCode.getStatus())
                .body(response);
    }
}