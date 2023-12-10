package com.zerobase.devidend.exception.impl;

import com.zerobase.devidend.exception.AbstractException;
import org.springframework.http.HttpStatus;

public class NotExistTicker extends AbstractException {

    @Override
    public int getStatusCode() {
        return HttpStatus.BAD_REQUEST.value();
    }

    @Override
    public String getMessage() {
        return "존재하지 않는 회사의 ticker 입니다.";
    }
}
