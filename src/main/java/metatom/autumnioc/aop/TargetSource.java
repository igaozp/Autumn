package metatom.autumnioc.aop;

/**
 * TargetSource 被代理的对象
 *
 * @author igaozp
 */
public class TargetSource {
    private Class<?> targetClass;
    private Object target;
    private Class<?>[] interfaces;

    public TargetSource(Object target, Class<?> targetClass, Class<?>... interfaces) {
        this.target = target;
        this.targetClass = targetClass;
        this.interfaces = interfaces;
    }

    public Class<?> getTargetClass() {
        return this.targetClass;
    }

    public Object getTarget() {
        return this.target;
    }

    public Class<?>[] getInterfaces() {
        return this.interfaces;
    }
}
