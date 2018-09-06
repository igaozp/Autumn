package metatom.autumnioc.factory;

import metatom.autumnioc.BeanDefinition;

/**
 * BeanFactory
 *
 * @author igaozp
 */
public interface BeanFactory {
    Object getBean(String name);

    void registerBeanDefinition(String name, BeanDefinition beanDefinition);
}
