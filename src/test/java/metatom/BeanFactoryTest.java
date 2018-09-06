package metatom;

import org.junit.Test;

/**
 * BeanFactoryTest
 *
 * @author igaozp
 */
public class BeanFactoryTest {
    @Test
    public void test() {
        // 初始化 BeanFactory
        BeanFactory beanFactory = new BeanFactory();

        // 注入 Bean
        BeanDefinition beanDefinition = new BeanDefinition(new HelloWorldService());
        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

        // 获取 Bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
