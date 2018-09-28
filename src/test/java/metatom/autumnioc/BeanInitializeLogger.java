package metatom.autumnioc;

import metatom.autumnioc.beans.BeanPostProcessor;

/**
 * BeanInitializeLogger
 *
 * @author igaozp
 */
public class BeanInitializeLogger implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("Initialize bean " + beanName + " start!");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("Initialize bean " + beanName + " end!");
        return bean;
    }
}
