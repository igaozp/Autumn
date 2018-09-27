package metatom.autumnioc.beans;

/**
 * BeanDefinitionReader
 *
 * @author igaozp
 */
public interface BeanDefinitionReader {
    /**
     * 通过路径加载 Bean 的配置文件
     *
     * @param location 资源路径
     * @throws Exception 抛出异常
     */
    void loadBeanDefinitions(String location) throws Exception;
}
