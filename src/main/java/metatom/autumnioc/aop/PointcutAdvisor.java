package metatom.autumnioc.aop;

/**
 * PointcutAdvisor 切点通知
 *
 * @author igaozp
 */
public interface PointcutAdvisor extends Advisor {
    /**
     * 获取切点
     *
     * @return 切点
     */
    Pointcut getPointcut();
}
