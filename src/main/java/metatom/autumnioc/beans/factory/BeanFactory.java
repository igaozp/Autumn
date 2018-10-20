package metatom.autumnioc.beans.factory;

/**
 * BeanFactory Bean 工厂
 *
 * @author igaozp
 */
public interface BeanFactory {
    /**
     * 通过名称获取 Bean 的实例
     *
     * @param name Bean 的名称
     * @return Bean 的实例
     * @throws Exception 异常
     */
    Object getBean(String name) throws Exception;
}
