package metatom.autumnioc.aop;

import metatom.autumnioc.beans.factory.BeanFactory;

/**
 * BeanFactoryAware
 *
 * @author igaozp
 */
public interface BeanFactoryAware {
    /**
     * 设置 Bean Factory
     *
     * @param beanFactory Bean Factory
     * @throws Exception 异常
     */
    void setBeanFactory(BeanFactory beanFactory) throws Exception;
}
