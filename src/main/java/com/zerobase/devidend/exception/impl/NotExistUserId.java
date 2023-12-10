package com.zerobase.devidend.exception.impl;

import com.zerobase.devidend.exception.AbstractException;
import org.springframework.http.HttpStatus;

public class NotExistUserId extends AbstractException {

    @Override
    public int getStatusCode() {
        return HttpStatus.BAD_REQUEST.value();
    }

    @Override
    public String getMessage() {
        return "존재하지 않는 ID 입니다.";
    }
}