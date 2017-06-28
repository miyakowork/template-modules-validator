package org.templateproject.validator.support;

/**
 * Created by wuwenbin on 2017/6/28.
 */
public class CheckResult {

    private Object invalidValue;
    private Object invalidBean;
    private String invalidParamName;
    private String message;
    private int severityLevel;
    private String[] profiles;

    public Object getInvalidValue() {
        return invalidValue;
    }

    public void setInvalidValue(Object invalidValue) {
        this.invalidValue = invalidValue;
    }

    public Object getInvalidBean() {
        return invalidBean;
    }

    public void setInvalidBean(Object invalidBean) {
        this.invalidBean = invalidBean;
    }

    public String getInvalidParamName() {
        return invalidParamName;
    }

    public void setInvalidParamName(String invalidParamName) {
        this.invalidParamName = invalidParamName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getSeverityLevel() {
        return severityLevel;
    }

    public void setSeverityLevel(int severityLevel) {
        this.severityLevel = severityLevel;
    }

    public String[] getProfiles() {
        return profiles;
    }

    public void setProfiles(String[] profiles) {
        this.profiles = profiles;
    }
}
