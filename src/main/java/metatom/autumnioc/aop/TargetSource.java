package metatom.autumnioc.aop;

/**
 * TargetSource 被代理的对象
 *
 * @author igaozp
 */
class TargetSource {
    /**
     * 对象的类型
     */
    private Class<?> targetClass;
    /**
     * 被代理对象的实例
     */
    private Object target;
    /**
     * 被代理对象实现的接口
     */
    private Class<?>[] interfaces;

    public TargetSource(Object target, Class<?> targetClass, Class<?>... interfaces) {
        this.target = target;
        this.targetClass = targetClass;
        this.interfaces = interfaces;
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }

    public void setTargetClass(Class<?> targetClass) {
        this.targetClass = targetClass;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Class<?>[] getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(Class<?>[] interfaces) {
        this.interfaces = interfaces;
    }
}
