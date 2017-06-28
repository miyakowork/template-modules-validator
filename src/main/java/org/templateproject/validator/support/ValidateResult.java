package org.templateproject.validator.support;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuwenbin on 2017/6/28.
 */
public class ValidateResult {

    private List<CheckResult> checkResults;
    private boolean hasError = false;


    public List<CheckResult> getCheckResults() {
        return checkResults;
    }

    public void setCheckResults(List<CheckResult> checkResults) {
        this.checkResults = checkResults;
    }

    public boolean isHasError() {
        return hasError;
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }

    public List<ErrorParam> errors() {
        List<ErrorParam> errorParams = new ArrayList<>(checkResults.size());
        for (CheckResult checkResult : getCheckResults()) {
            ErrorParam errorParam = new ErrorParam();
            errorParam.setName(checkResult.getInvalidParamName());
            errorParam.setValue(checkResult.getInvalidValue());
            errorParam.setMessage(checkResult.getMessage());
            errorParams.add(errorParam);
        }
        return errorParams;
    }

    public List<String> errorNames() {
        List<String> errorNames = new ArrayList<>(checkResults.size());
        for (CheckResult checkResult : getCheckResults()) {
            errorNames.add(checkResult.getInvalidParamName());
        }
        return errorNames;
    }

    public List<Object> errorValues() {
        List<Object> errorValues = new ArrayList<>(checkResults.size());
        for (CheckResult checkResult : getCheckResults()) {
            errorValues.add(checkResult.getInvalidValue());
        }
        return errorValues;
    }

    public List<String> errorMessage() {
        List<String> errorMessages = new ArrayList<>(checkResults.size());
        for (CheckResult checkResult : getCheckResults()) {
            errorMessages.add(checkResult.getMessage());
        }
        return errorMessages;
    }
}
