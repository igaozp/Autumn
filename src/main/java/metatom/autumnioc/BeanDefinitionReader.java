package metatom.autumnioc;

/**
 * BeanDefinitionReader
 *
 * @author igaozp
 */
public interface BeanDefinitionReader {
    void loadBeanDefinitions(String location) throws Exception;
}
