package com.ottepel_hack.controllers;

/**
 * Created by iistomin on 18/03/17.
 */
public class Request {

    private String type;
    private Object body;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
