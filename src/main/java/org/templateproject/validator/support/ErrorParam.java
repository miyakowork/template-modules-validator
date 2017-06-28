package org.templateproject.validator.support;

/**
 * Created by wuwenbin on 2017/6/28.
 */
public class ErrorParam {
    private String name;
    private Object value;
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
