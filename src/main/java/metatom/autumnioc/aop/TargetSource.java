package metatom.autumnioc.aop;

/**
 * TargetSource 被代理的对象
 *
 * @author igaozp
 */
public class TargetSource {
    private Class<?>[] targetClass;
    private Object target;

    public TargetSource(Object target, Class<?>... targetClass) {
        this.target = target;
        this.targetClass = targetClass;
    }

    public Class<?>[] getTargetClass() {
        return this.targetClass;
    }

    public Object getTarget() {
        return this.target;
    }
}
