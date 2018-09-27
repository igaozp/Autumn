package metatom.autumnioc.aop;

import metatom.autumnioc.HelloWorldService;
import metatom.autumnioc.context.ApplicationContext;
import metatom.autumnioc.context.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * JdkDynamicAopProxyTest
 *
 * @author igaozp
 */
public class JdkDynamicAopProxyTest {
    @Test
    public void testInterceptor() throws Exception {
        // 基于 IOC 调用
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("autumnioc.xml");
        HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
        helloWorldService.helloWorld();

        // 设置被代理对象
        AdvisedSupport advisedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(helloWorldService, HelloWorldService.class);
        advisedSupport.setTargetSource(targetSource);

        // 设置拦截器
        TimerInterceptor timerInterceptor = new TimerInterceptor();
        advisedSupport.setMethodInterceptor(timerInterceptor);

        // 创建代理
        JdkDynamicAopProxy jdkDynamicAopProxy = new JdkDynamicAopProxy(advisedSupport);
        HelloWorldService helloWorldServiceProxy = (HelloWorldService) jdkDynamicAopProxy.getProxy();

        // 基于 AOP 调用
        helloWorldServiceProxy.helloWorld();
    }
}
