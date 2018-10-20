package metatom.autumnioc.aop;

import metatom.autumnioc.HelloWorldService;
import metatom.autumnioc.HelloWorldServiceImpl;
import metatom.autumnioc.context.ApplicationContext;
import metatom.autumnioc.context.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * CglibAopProxyTest
 *
 * @author igaozp
 */
public class Cglib2AopProxyTest {
    @Test
    public void testInterceptor() throws Exception {
        // 不使用 AOP 调用
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("autumnioc.xml");
        HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
        helloWorldService.helloWorld();

        // 使用 AOP 调用
        // 设置被代理的对象
        AdvisedSupport advisedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(helloWorldService, HelloWorldServiceImpl.class, HelloWorldService.class);
        advisedSupport.setTargetSource(targetSource);

        // 设置拦截器
        TimerInterceptor timerInterceptor = new TimerInterceptor();
        advisedSupport.setMethodInterceptor(timerInterceptor);

        // 创建代理
        Cglib2AopProxy cglib2AopProxy = new Cglib2AopProxy(advisedSupport);
        HelloWorldService helloWorldServiceProxy = (HelloWorldService) cglib2AopProxy.getProxy();

        // 基于 AOP 的调用
        helloWorldServiceProxy.helloWorld();
    }
}
