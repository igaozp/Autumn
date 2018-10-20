package metatom.autumnioc.beans;

import lombok.Getter;
import metatom.autumnioc.beans.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * AbstractBeanDefinitionReader
 *
 * @author igaozp
 */
@Getter
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    private Map<String, BeanDefinition> registry;
    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.registry = new HashMap<>();
        this.resourceLoader = resourceLoader;
    }
}
