package metatom.autumnioc.aop;

import lombok.Getter;

/**
 * TargetSource 被代理的对象
 *
 * @author igaozp
 */
@Getter
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
}
