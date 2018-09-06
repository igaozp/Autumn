package metatom.autumnioc;

/**
 * @author igaozp
 */
public class BeanDefinition {
    private Object bean;
    private Class beanClass;
    private String beanClassName;

    public BeanDefinition() {
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }


    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        try {
            this.beanClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }
}