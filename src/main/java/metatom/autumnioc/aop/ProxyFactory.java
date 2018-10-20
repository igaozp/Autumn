package metatom.autumnioc.aop;

/**
 * ProxyFactory 代理工厂
 *
 * @author igaozp
 */
public class ProxyFactory extends AdvisedSupport implements AopProxy {
    @Override
    public Object getProxy() {
        return createProxy().getProxy();
    }

    private AopProxy createProxy() {
        return new Cglib2AopProxy(this);
    }
}
