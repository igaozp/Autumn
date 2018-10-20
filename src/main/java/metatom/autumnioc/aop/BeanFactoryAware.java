package metatom.autumnioc.aop;

import metatom.autumnioc.beans.factory.BeanFactory;

/**
 * BeanFactoryAware 感知 Bean 工厂
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
