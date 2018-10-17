package metatom.autumnioc.aop;

/**
 * ProxyFactory
 *
 * @author igaozp
 */
public class ProxyFactory extends AdvisedSupport implements AopProxy {
    @Override
    public Object getProxy() {
        return createProxy().getProxy();
    }

    protected final AopProxy createProxy() {
        return new Cglib2AopProxy(this);
    }
}
