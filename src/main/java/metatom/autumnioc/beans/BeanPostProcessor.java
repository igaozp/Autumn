package metatom.autumnioc.beans;

/**
 * BeanPostProcessor
 *
 * @author igaozp
 */
public interface BeanPostProcessor {
    /**
     * Bean 初始化前的前置处理
     *
     * @param bean 初始化的 Bean 对象
     * @param beanName Bean 的名称
     * @return Bean 实例对象
     * @throws Exception 异常
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception;

    /**
     * Bean 初始化后的后置处理
     *
     * @param bean 初始化的 Bean 对象
     * @param beanName Bean 的名称
     * @return Bean 实例对象
     * @throws Exception 异常
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws Exception;
}
