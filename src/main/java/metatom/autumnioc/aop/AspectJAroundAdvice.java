package metatom.autumnioc.aop;

import lombok.Data;
import metatom.autumnioc.beans.factory.BeanFactory;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * AspectJAroundAdvice 切面环绕通知
 *
 * @author igaozp
 */
@Data
public class AspectJAroundAdvice implements Advice, MethodInterceptor {
    /**
     * Bean 工厂
     */
    private BeanFactory beanFactory;
    /**
     * 通知方法
     */
    private Method aspectJAdviceMethod;
    /**
     * 切面的实例名称
     */
    private String aspectInstanceName;

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        return aspectJAdviceMethod.invoke(beanFactory.getBean(aspectInstanceName), methodInvocation);
    }
}
