package com.bidan.global.exception;

import lombok.Getter;

// Checked Exception 예외 처리를 위한 BusinessException
/* 각 도메인별 Exception이 BusinessException이라는 추상 클래스를 상속받아 구현
* throw를 통해 Unchecked Exception 발생 시 UserException 예외가 발생하여
* GlobalExceptionHandler쪽에서 받아 처리 */
/* global에서 형태만 구현하고 도메인 쪽에서 자식으로 상속 받아 실질적 구현을 하는 구조*/
@Getter
public abstract class BusinessException
        extends RuntimeException {

    private final ErrorCode errorCode;

    protected BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

}