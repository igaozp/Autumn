package metatom.autumnioc.context;

import metatom.autumnioc.beans.BeanDefinition;
import metatom.autumnioc.beans.factory.AbstractBeanFactory;
import metatom.autumnioc.beans.factory.AutowireCapableBeanFactory;
import metatom.autumnioc.beans.io.ResourceLoader;
import metatom.autumnioc.beans.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * ClassPathXmlApplicationContext
 *
 * @author igaozp
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {
    private String configLocation;

    public ClassPathXmlApplicationContext(String configLocation) throws Exception {
        this(configLocation, new AutowireCapableBeanFactory());
    }

    public ClassPathXmlApplicationContext(String configLocation, AbstractBeanFactory beanFactory) throws Exception {
        super(beanFactory);
        this.configLocation = configLocation;
        refresh();
    }

    @Override
    public void refresh() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }
    }
}
