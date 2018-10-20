package metatom.autumnioc.aop;

/**
 * AopProxy AOP 代理
 *
 * @author igaozp
 */
public interface AopProxy {
    /**
     * 获取代理后的对象
     *
     * @return 代理后的对象
     */
    Object getProxy();
}
