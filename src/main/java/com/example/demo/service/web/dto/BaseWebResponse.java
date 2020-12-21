package com.example.demo.service.web.dto;

public class BaseWebResponse<T> {
    public enum ErrorCode {
        ENTITY_NOT_FOUND
    }

    private ErrorCode errorCode;
    private T data;

//    public static BaseWebResponse successNoData() {
//        return BaseWebResponse
//                .build();
//    }
//
//    public static <T> BaseWebResponse<T> successWithData(T data) {
//        return BaseWebResponse.<T>builder()
//                .data(data)
//                .build();
//    }
//
//    public static BaseWebResponse error(ErrorCode errorCode) {
//        return BaseWebResponse.builder()
//                .errorCode(errorCode)
//                .build();
//    }
}
