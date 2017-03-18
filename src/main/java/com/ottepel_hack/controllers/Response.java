package com.ottepel_hack.controllers;

/**
 * Created by iistomin on 18/03/17.
 */
public class Response {
    public static final String OK = "ok";
    public static final String ERROR = "error";

    private String status;
    private Object body;

    public Response() {
    }

    public Response(boolean status, Object body) {
        this.status = status ? OK : ERROR;
        this.body = body;
    }

    public Response(Object body) {
        this.status = OK;
        this.body = body;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
