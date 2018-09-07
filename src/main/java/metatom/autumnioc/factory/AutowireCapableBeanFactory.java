package metatom.autumnioc.factory;

import metatom.autumnioc.BeanDefinition;
import metatom.autumnioc.PropertyValue;

import java.lang.reflect.Field;

/**
 * AutowireCapableBeanFactory
 *
 * @author igaozp
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = createBeanInstance(beanDefinition);
        applyPropertyValues(bean, beanDefinition);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        return beanDefinition.getBeanClass().newInstance();
    }

    protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {
        for (PropertyValue value : beanDefinition.getPropertyValues().getPropertyValues()) {
            Field declaredField = bean.getClass().getDeclaredField(value.getName());
            declaredField.setAccessible(true);
            declaredField.set(bean, value.getValue());
        }
    }
}
