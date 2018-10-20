package metatom.autumnioc.aop;

import lombok.Data;
import org.aopalliance.intercept.MethodInterceptor;

/**
 * AdviseSupport
 *
 * @author igaozp
 */
@Data
class AdvisedSupport {
    /**
     * 被代理的对象
     */
    private TargetSource targetSource;
    /**
     * 方法拦截器
     */
    private MethodInterceptor methodInterceptor;
    /**
     * 方法匹配器
     */
    private MethodMatcher methodMatcher;
}
