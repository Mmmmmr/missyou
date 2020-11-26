package com.jiang.missyou.exception.http;

public class ParamterException extends HttpException{
    public ParamterException(int code) {
        this.httpStatusCode = 400;
        this.code = code;
    }
}
