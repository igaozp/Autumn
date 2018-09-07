package metatom.autumnioc;

import metatom.autumnioc.factory.AutowireCapableBeanFactory;
import metatom.autumnioc.factory.BeanFactory;
import org.junit.Test;

/**
 * BeanFactoryTest
 *
 * @author igaozp
 */
public class BeanFactoryTest {
    @Test
    public void test() throws Exception {
        // 初始化 BeanFactory
        BeanFactory beanFactory = new AutowireCapableBeanFactory();

        // 注入 Bean
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("metatom.autumnioc.HelloWorldService");

        // 设置属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("text", "Hello World!"));
        beanDefinition.setPropertyValues(propertyValues);

        // 生成 Bean
        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

        // 获取 Bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
