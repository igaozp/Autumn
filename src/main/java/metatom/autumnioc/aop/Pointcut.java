package metatom.autumnioc.aop;

/**
 * Pointcut
 *
 * @author igaozp
 */
public interface Pointcut {
    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}
