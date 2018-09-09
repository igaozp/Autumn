package metatom.autumnioc;

import metatom.autumnioc.factory.AutowireCapableBeanFactory;
import metatom.autumnioc.factory.BeanFactory;
import metatom.autumnioc.io.ResourceLoader;
import metatom.autumnioc.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;

/**
 * BeanFactoryTest
 *
 * @author igaozp
 */
public class BeanFactoryTest {
    @Test
    public void test() throws Exception {
        // 读取配置文件
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("autumnioc.xml");

        // 初始化 BeanFactory 并注册 Bean
        BeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        // 获取 Bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
