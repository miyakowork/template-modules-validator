package org.templateproject.validator.factory;

import jodd.util.StringUtil;
import jodd.vtor.Violation;
import jodd.vtor.Vtor;
import org.templateproject.lang.TP;
import org.templateproject.validator.support.CheckResult;
import org.templateproject.validator.support.ValidateResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuwenbin on 2017/6/28.
 */
public class TpValidator {

    private static final String DEFAULT_RESOURCE = "template-validator";

    private String resource = DEFAULT_RESOURCE;

    public TpValidator() {
        this(DEFAULT_RESOURCE);
    }

    public TpValidator(String resource) {
        this.resource = StringUtil.isNotEmpty(resource) ? resource : DEFAULT_RESOURCE;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public ValidateResult validate(Object bean) {
        Vtor vtor = new Vtor();
        vtor.validate(bean);
        ValidateResult validateResult = new ValidateResult();
        List<Violation> violations = vtor.getViolations();
        if (violations.isEmpty() || violations == null) {
            return validateResult;
        } else {
            validateResult.setHasError(true);
            List<CheckResult> checkResults = new ArrayList<>(violations.size());
            for (Violation violation : violations) {
                CheckResult checkResult = new CheckResult();
                checkResult.setInvalidBean(violation.getValidatedObject());
                checkResult.setInvalidParamName(violation.getName());
                checkResult.setInvalidValue(violation.getInvalidValue());
                String res = this.resource.endsWith(".properties") ? this.resource : this.resource.concat(".properties");
                String errorMessage = TP.properties.getProperty("/".concat(res), violation.getCheck().getMessage(), violation.getCheck().getMessage());
                checkResult.setMessage(errorMessage);
                checkResult.setProfiles(violation.getCheck().getProfiles());
                checkResult.setSeverityLevel(violation.getCheck().getSeverity());
                checkResults.add(checkResult);
            }
            validateResult.setCheckResults(checkResults);
            return validateResult;
        }

    }

}
