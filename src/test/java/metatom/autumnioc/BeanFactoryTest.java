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
    public void test() {
        // 初始化 BeanFactory
        BeanFactory beanFactory = new AutowireCapableBeanFactory();

        // 注入 Bean
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("metatom.autumnioc.HelloWorldService");
        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

        // 获取 Bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
