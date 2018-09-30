package metatom.autumnioc.aop;

import metatom.autumnioc.HelloWorldService;
import metatom.autumnioc.HelloWorldServiceImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * AspectJExpressionPointcutTest
 *
 * @author igaozp
 */
public class AspectJExpressionPointcutTest {
    @Test
    public void testClassFilter() {
        String expression = "execution(* metatom.autumnioc.*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.getClassFilter().matches(HelloWorldService.class);
        Assert.assertTrue(matches);
    }

    @Test
    public void testMethodInterceptor() throws Exception {
        String expression = "execution(* metatom.autumnioc.*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.getMethodMatcher().
                matches(HelloWorldServiceImpl.class.getDeclaredMethod("helloWorld"), HelloWorldServiceImpl.class);
        Assert.assertTrue(matches);
    }
}
