package metatom.autumnioc.beans.factory;

import metatom.autumnioc.aop.BeanFactoryAware;
import metatom.autumnioc.beans.BeanDefinition;
import metatom.autumnioc.BeanReference;
import metatom.autumnioc.beans.PropertyValue;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * AutowireCapableBeanFactory
 * 有自动注入能力的 Bean 工厂
 *
 * @author igaozp
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {
        if (bean instanceof BeanFactoryAware) {
            // 设置工厂
            ((BeanFactoryAware) bean).setBeanFactory(this);
        }

        for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()) {
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference) {
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getName());
            }

            try {
                // 获取属性的 Set 方法
                Method declaredMethod = bean.getClass().getDeclaredMethod("set" + propertyValue.getName()
                        .substring(0, 1).toUpperCase() + propertyValue.getName().substring(1), value.getClass());
                // 取消权限控制，可以访问 private 成员
                declaredMethod.setAccessible(true);
                // 属性值注入到 Bean 中
                declaredMethod.invoke(bean, value);
            } catch (NoSuchMethodException e) {
                // 若没有 Set 方法，直接通过字段注入属性值
                Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
                declaredField.setAccessible(true);
                declaredField.set(bean, value);
            }
        }
    }
}
