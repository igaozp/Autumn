package metatom.autumnioc.aop;

/**
 * AbstractAopProxy 抽象 AOP 代理
 *
 * @author igaozp
 */
abstract class AbstractAopProxy implements AopProxy {
    AdvisedSupport advised;

    AbstractAopProxy(AdvisedSupport advised) {
        this.advised = advised;
    }
}
