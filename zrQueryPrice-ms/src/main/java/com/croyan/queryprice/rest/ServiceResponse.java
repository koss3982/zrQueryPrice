package com.croyan.queryprice.rest;

import com.croyan.queryprice.bean.ProductPriceBean;

public class ServiceResponse<T> {

    private boolean ok;
    private String message;
    private T data;

    private ServiceResponse() {

    }

    public boolean isOk() {
        return ok;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public static class Builder<T> {
        private ServiceResponse instance;

        public Builder() {
            instance = new ServiceResponse<T>();
        }

        public Builder responseIsOk(boolean isOk) {
            instance.ok = isOk;
            return this;
        }

        public Builder message(String message) {
            instance.message = message;
            return this;
        }

        public Builder data(T data) {
            instance.data = data;
            return this;
        }

        public ServiceResponse build() {
            return instance;
        }

    }
}


