package metatom.autumnioc;

import metatom.autumnioc.beans.BeanDefinition;
import metatom.autumnioc.beans.factory.AbstractBeanFactory;
import metatom.autumnioc.beans.factory.AutowireCapableBeanFactory;
import metatom.autumnioc.beans.factory.BeanFactory;
import metatom.autumnioc.beans.io.ResourceLoader;
import metatom.autumnioc.beans.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;

/**
 * BeanFactoryTest
 *
 * @author igaozp
 */
public class BeanFactoryTest {
    @Test
    public void testLazy() throws Exception {
        // 读取配置文件
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("autumnioc.xml");

        // 初始化 BeanFactory 并注册 Bean
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        // 获取 Bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }

    @Test
    public void testPreInstantiate() throws Exception {
        // 获取配置文件
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("autumnioc.xml");

        // 初始化 BeanFactory 并注册 Bean
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        // 初始化 Bean
        beanFactory.preInstantiateSingletons();

        // 获取 Bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
