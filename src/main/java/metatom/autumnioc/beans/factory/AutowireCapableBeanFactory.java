package metatom.autumnioc.beans.factory;

import metatom.autumnioc.beans.BeanDefinition;
import metatom.autumnioc.BeanReference;
import metatom.autumnioc.beans.PropertyValue;

import java.lang.reflect.Field;

/**
 * AutowireCapableBeanFactory
 *
 * @author igaozp
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {
        for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()) {
            Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
            declaredField.setAccessible(true);
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference) {
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getName());
            }
            declaredField.set(bean, value);
        }
    }
}
