package metatom.autumnioc.context;

import metatom.autumnioc.HelloWorldService;
import org.junit.Test;

/**
 * ApplicationContextTest
 *
 * @author igaozp
 */
public class ApplicationContextTest {
    @Test
    public void test() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("autumnioc.xml");
        HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
