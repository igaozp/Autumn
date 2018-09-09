package metatom.autumnioc.factory;

import metatom.autumnioc.BeanDefinition;

/**
 * BeanFactory
 *
 * @author igaozp
 */
public interface BeanFactory {
    /**
     * @param name Bean 的名称
     * @return Bean 的实例
     */
    Object getBean(String name);

    /**
     * @param name           Bean 的名称
     * @param beanDefinition Bean 的定义实例
     * @throws Exception 异常
     */
    void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;
}
