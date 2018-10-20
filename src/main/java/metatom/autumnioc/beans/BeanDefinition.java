package metatom.autumnioc.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * BeanDefinition Bean 的定义结构
 *
 * @author igaozp
 */
@Data
@NoArgsConstructor
public class BeanDefinition {
    private Object bean;
    private Class beanClass;
    private String beanClassName;
    private PropertyValues propertyValues = new PropertyValues();

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;

        try {
            this.beanClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
