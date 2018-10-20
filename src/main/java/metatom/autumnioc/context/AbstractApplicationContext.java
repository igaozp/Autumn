package metatom.autumnioc.context;

import metatom.autumnioc.beans.BeanPostProcessor;
import metatom.autumnioc.beans.factory.AbstractBeanFactory;

import java.util.List;

/**
 * AbstractApplicationContext
 *
 * @author igaozp
 */
public abstract class AbstractApplicationContext implements ApplicationContext {
    private AbstractBeanFactory beanFactory;

    AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    /**
     * 创建加载相关配置
     *
     * @throws Exception 异常
     */
    void refresh() throws Exception {
        loadBeanDefinitions(beanFactory);
        registerBeanPostProcessors(beanFactory);
        onRefresh();
    }

    /**
     * 加载 Bean 的定义
     *
     * @param beanFactory Bean Factory
     * @throws Exception 异常
     */
    protected abstract void loadBeanDefinitions(AbstractBeanFactory beanFactory) throws Exception;

    /**
     * 注册 Bean 的处理器
     *
     * @param beanFactory Bean 工厂实例
     * @throws Exception 异常
     */
    private void registerBeanPostProcessors(AbstractBeanFactory beanFactory) throws Exception {
        // 获取处理器
        List beanPostProcessors = beanFactory.getBeansForType(BeanPostProcessor.class);
        for (Object beanPostProcessor : beanPostProcessors) {
            beanFactory.addBeanPostProcessor((BeanPostProcessor) beanPostProcessor);
        }
    }

    /**
     * 扩展初始化其他 Bean
     *
     * @throws Exception 异常
     */
    private void onRefresh() throws Exception {
        beanFactory.preInstantiateSingletons();
    }

    @Override
    public Object getBean(String name) throws Exception {
        return beanFactory.getBean(name);
    }
}
