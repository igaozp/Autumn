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
    /**
     * 切点解析器
     */
    private PointcutParser pointcutParser;
    /**
     * 表达式
     */
    private String expression;
    /**
     * 切点表达式
     */
    private PointcutExpression pointcutExpression;
    /**
     * 切点原语集合
     */
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

    AspectJExpressionPointcut() {
        this(DEFAULT_SUPPORT_PRIMITIVES);
    }

    private AspectJExpressionPointcut(Set<PointcutPrimitive> pointcutPrimitives) {
        // 通过切点原语集合获取切点解析器
        pointcutParser = PointcutParser.
                getPointcutParserSupportingSpecifiedPrimitivesAndUsingContextClassloaderForResolution
                        (pointcutPrimitives);
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

    /**
     * 检查准备匹配
     */
    private void checkReadyToMatch() {
        // 若没有切点表达式则生成切点表达式
        if (pointcutExpression == null) {
            pointcutExpression = buildPointcutExpression();
        }
    }

    /**
     * 构建切点表达式
     *
     * @return 切点表达式
     */
    private PointcutExpression buildPointcutExpression() {
        return pointcutParser.parsePointcutExpression(expression);
    }

    void setExpression(String expression) {
        this.expression = expression;
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
