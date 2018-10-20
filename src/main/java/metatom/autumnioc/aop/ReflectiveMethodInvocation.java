package metatom.autumnioc.aop;

import lombok.Data;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

/**
 * ReflectiveMethodInvocation 反射性方法引用
 *
 * @author igaozp
 */
@Data
public class ReflectiveMethodInvocation implements MethodInvocation {
    /**
     * 目标对象
     */
    private Object target;
    /**
     * 目标对象的方法
     */
    private Method method;
    /**
     * 参数列表
     */
    private Object[] arguments;

    ReflectiveMethodInvocation(Object target, Method method, Object[] arguments) {
        this.target = target;
        this.method = method;
        this.arguments = arguments;
    }

    @Override
    public Object getThis() {
        return this.target;
    }

    @Override
    public AccessibleObject getStaticPart() {
        return this.method;
    }

    @Override
    public Object proceed() throws Throwable {
        return method.invoke(target, arguments);
    }
}
