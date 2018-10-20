package metatom.autumnioc.aop;

import java.lang.reflect.Method;

/**
 * MethodMatcher 检查目标方法是否有资格获取 Advice
 *
 * @author igaozp
 */
public interface MethodMatcher {
    /**
     * 检查给定的方法是否匹配
     *
     * @param method      给定的方法
     * @param targetClass 目标类
     * @return 匹配结果
     */
    boolean matches(Method method, Class targetClass);
}
