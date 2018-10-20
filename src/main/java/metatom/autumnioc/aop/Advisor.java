package metatom.autumnioc.aop;

import org.aopalliance.aop.Advice;

/**
 * Advisor 通知对象
 *
 * @author igaozp
 */
public interface Advisor {
    /**
     * 获取通知对象
     *
     * @return 通知对象
     */
    Advice getAdvice();
}
