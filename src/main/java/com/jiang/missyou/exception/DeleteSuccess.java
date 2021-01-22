package com.jiang.missyou.exception;

import com.jiang.missyou.exception.http.HttpException;

public class DeleteSuccess extends HttpException {
    public DeleteSuccess(int code){
        this.httpStatusCode = 200;
        this.code = code;
    }
}
