package metatom.autumnioc.aop;

import java.lang.reflect.Method;

/**
 * MethodMatcher
 *
 * @author igaozp
 */
public interface MethodMatcher {
    boolean matches(Method method, Class targetClass);
}
