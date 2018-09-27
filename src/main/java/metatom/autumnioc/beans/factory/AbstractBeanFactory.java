package metatom.autumnioc.beans.factory;

import metatom.autumnioc.beans.BeanDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * AbstractBeanFactory
 *
 * @author igaozp
 */
public abstract class AbstractBeanFactory implements BeanFactory {
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
    private final List<String> beanDefinitionNames = new ArrayList<>();

    @Override
    public Object getBean(String name) throws Exception {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if (beanDefinition == null) {
            throw new IllegalArgumentException("No bean named " + name + " is defined");
        }
        Object bean = beanDefinition.getBean();
        if (bean == null) {
            bean = doCreateBean(beanDefinition);
        }
        return bean;
    }


    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
        beanDefinitionNames.add(name);
    }

    public void preInstantiateSingletons() throws Exception {
        for (String beanName : this.beanDefinitionNames) {
            getBean(beanName);
        }
    }

    /**
     * 初始化 Bean
     *
     * @param beanDefinition beanDefinition
     * @return Object
     * @throws Exception 抛出异常
     */
    protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;
}
