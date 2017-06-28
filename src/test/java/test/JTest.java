package test;

import jodd.vtor.Vtor;
import org.junit.Test;
import org.templateproject.validator.factory.TpValidator;
import org.templateproject.validator.support.ErrorParam;
import org.templateproject.validator.support.ValidateResult;

/**
 * Created by wuwenbin on 2017/5/11.
 */
public class JTest {

    private TpValidator validator = new TpValidator();

    @Test
    public void t() {
        Vtor vtor = new Vtor();
        User user = new User();
        user.setAge(1);
        user.setUsername("wwb");
//        vtor.validate(user);
//        for (Violation violation : vtor.getViolations()) {
//            System.out.println("不合法的值：" + violation.getInvalidValue());
//            System.out.println("验证器：" + violation.getConstraint());
//            System.out.println("不合法的参数名：" + violation.getName());
//            System.out.println("不合法的javaBean：" + violation.getValidatedObject());
//            System.out.println("错误信息：" + violation.getCheck().getMessage());
//            System.out.println("验证器：" + violation.getCheck().getConstraint());
//            System.out.println("不合法的参数名：" + violation.getCheck().getName());
//            for (String s : violation.getCheck().getProfiles()) {
//                System.out.println("profiles：" + s);
//            }
//            System.out.println("severity：" + violation.getCheck().getSeverity());
//        }
//        System.out.println(JTest.class.getResource(""));
        ValidateResult validateResult = validator.validate(user);
        for (ErrorParam errorParam : validateResult.errors()) {
            System.out.println(errorParam.getName() + " : " + errorParam.getValue() + " --> " + errorParam.getMessage());
        }
    }
}
