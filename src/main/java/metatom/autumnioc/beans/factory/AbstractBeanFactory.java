package metatom.autumnioc.beans.factory;

import metatom.autumnioc.beans.BeanDefinition;
import metatom.autumnioc.beans.BeanPostProcessor;

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
    private List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    @Override
    public Object getBean(String name) throws Exception {
        // 获取指定 Bean 的定义结构
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if (beanDefinition == null) {
            throw new IllegalArgumentException("No bean named " + name + " is defined");
        }

        // 获取 Bean
        Object bean = beanDefinition.getBean();
        if (bean == null) {
            // 若没有则构建 Bean
            bean = doCreateBean(beanDefinition);
            bean = initializeBean(bean, name);
            beanDefinition.setBean(bean);
        }

        return bean;
    }

    /**
     * 创建 Bean
     *
     * @param beanDefinition Bean 的定义结构
     * @return Object Bean 的实例
     * @throws Exception 异常
     */
    private Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = createBeanInstance(beanDefinition);
        beanDefinition.setBean(bean);
        applyPropertyValues(bean, beanDefinition);

        return bean;
    }

    /**
     * 创建 Bean 的实例对象
     *
     * @param beanDefinition Bean 的定义结构
     * @return Bean 实例对象
     * @throws Exception 类实例化相关的异常
     */
    private Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        return beanDefinition.getBeanClass().getConstructor().newInstance();
    }

    /**
     * 设置 Bean 的属性值
     *
     * @param bean           Bean 的实例
     * @param beanDefinition Bean 的定义结构
     * @throws Exception 异常
     */
    protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {
    }

    /**
     * 初始化 Bean
     *
     * @param bean Bean 实例对象
     * @param name Bean 名称
     * @return Bean 实例对象
     * @throws Exception 异常
     */
    private Object initializeBean(Object bean, String name) throws Exception {
        // Bean 初始化之前执行的操作
        for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
            bean = beanPostProcessor.postProcessBeforeInitialization(bean, name);
        }

        // Bean 初始化之后执行的操作
        for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
            bean = beanPostProcessor.postProcessAfterInitialization(bean, name);
        }

        return bean;
    }

    /**
     * 注册 Bean
     *
     * @param name           Bean 的名称
     * @param beanDefinition Bean 的定义结构
     */
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
        beanDefinitionNames.add(name);
    }

    /**
     * 预先实例化已有的 Bean
     *
     * @throws Exception 异常
     */
    public void preInstantiateSingletons() throws Exception {
        for (String beanName : this.beanDefinitionNames) {
            getBean(beanName);
        }
    }

    /**
     * 添加 Bean 的处理器
     *
     * @param beanPostProcessor Bean 的处理器
     */
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.add(beanPostProcessor);
    }

    /**
     * 获取指定类型的 Bean 实例
     *
     * @param type 要求的类型
     * @return Bean 的实例列表
     * @throws Exception 异常
     */
    public List getBeansForType(Class type) throws Exception {
        List beans = new ArrayList<>();
        for (String beanDefinitionName : beanDefinitionNames) {
            if (type.isAssignableFrom(beanDefinitionMap.get(beanDefinitionName).getBeanClass())) {
                beans.add(getBean(beanDefinitionName));
            }
        }

        return beans;
    }
}
