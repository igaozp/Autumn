package metatom.autumnioc.aop;

/**
 * PointcutAdvisor
 *
 * @author igaozp
 */
public interface PointcutAdvisor extends Advisor {
    Pointcut getPointcut();
}
