package com.jiang.missyou.exception.http;

public class UnAuthenticatedException extends HttpException {
    public UnAuthenticatedException(int code) {
        this.code = code;
        this.httpStatusCode = 401;
    }
}
