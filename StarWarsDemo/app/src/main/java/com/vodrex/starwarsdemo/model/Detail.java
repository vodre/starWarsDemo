package com.vodrex.starwarsdemo.model;

/**
 * Created by vodrex on 10/10/16.
 */
public class Detail {
    private String parameter;
    private String value;

    public Detail() {
    }

    public Detail(String parameter, String value) {
        this.parameter = parameter;
        this.value = value;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
