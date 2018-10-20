package metatom.autumnioc.aop;

/**
 * Pointcut 切点
 *
 * @author igaozp
 */
public interface Pointcut {
    /**
     * 获取类的过滤器
     *
     * @return 类过滤器
     */
    ClassFilter getClassFilter();

    /**
     * 获取方法的匹配器
     *
     * @return 方法匹配器
     */
    MethodMatcher getMethodMatcher();
}
