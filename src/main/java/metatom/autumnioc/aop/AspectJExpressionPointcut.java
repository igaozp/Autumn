package metatom.autumnioc.aop;

import org.aspectj.weaver.tools.PointcutExpression;
import org.aspectj.weaver.tools.PointcutParser;
import org.aspectj.weaver.tools.PointcutPrimitive;
import org.aspectj.weaver.tools.ShadowMatch;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * AspectJExpressionPointcut
 *
 * @author igaozp
 */
public class AspectJExpressionPointcut implements Pointcut, ClassFilter, MethodMatcher {
    private PointcutParser pointcutParser;
    private String expression;
    private PointcutExpression pointcutExpression;
    private static final Set<PointcutPrimitive> DEFAULT_SUPPORT_PRIMITIVES = new HashSet<>();

    static {
        DEFAULT_SUPPORT_PRIMITIVES.add(PointcutPrimitive.EXECUTION);
        DEFAULT_SUPPORT_PRIMITIVES.add(PointcutPrimitive.ARGS);
        DEFAULT_SUPPORT_PRIMITIVES.add(PointcutPrimitive.REFERENCE);
        DEFAULT_SUPPORT_PRIMITIVES.add(PointcutPrimitive.THIS);
        DEFAULT_SUPPORT_PRIMITIVES.add(PointcutPrimitive.TARGET);
        DEFAULT_SUPPORT_PRIMITIVES.add(PointcutPrimitive.WITHIN);
        DEFAULT_SUPPORT_PRIMITIVES.add(PointcutPrimitive.AT_ANNOTATION);
        DEFAULT_SUPPORT_PRIMITIVES.add(PointcutPrimitive.AT_WITHIN);
        DEFAULT_SUPPORT_PRIMITIVES.add(PointcutPrimitive.AT_ARGS);
        DEFAULT_SUPPORT_PRIMITIVES.add(PointcutPrimitive.AT_TARGET);
    }

    public AspectJExpressionPointcut() {
        this(DEFAULT_SUPPORT_PRIMITIVES);
    }

    public AspectJExpressionPointcut(Set<PointcutPrimitive> pointcutPrimitives) {
        pointcutParser = PointcutParser.getPointcutParserSupportingSpecifiedPrimitivesAndUsingContextClassloaderForResolution(pointcutPrimitives);
    }

    protected void checkReadyToMatch() {
        if (pointcutExpression == null) {
            pointcutExpression = buildPointcutExpression();
        }
    }

    private PointcutExpression buildPointcutExpression() {
        return pointcutParser.parsePointcutExpression(expression);
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public boolean matches(Class targetClass) {
        checkReadyToMatch();
        return pointcutExpression.couldMatchJoinPointsInType(targetClass);
    }

    @Override
    public boolean matches(Method method, Class targetClass) {
        checkReadyToMatch();
        ShadowMatch shadowMatch = pointcutExpression.matchesMethodExecution(method);
        if (shadowMatch.alwaysMatches()) {
            return true;
        } else if (shadowMatch.neverMatches()) {
            return false;
        }
        return false;
    }

    @Override
    public ClassFilter getClassFilter() {
        return this;
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return this;
    }
}
