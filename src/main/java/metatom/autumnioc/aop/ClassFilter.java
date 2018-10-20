package metatom.autumnioc.aop;

/**
 * ClassFilter
 *
 * @author igaozp
 */
public interface ClassFilter {
    /**
     * 对类进行匹配
     *
     * @param targetClass 目标类
     * @return 匹配结果
     */
    boolean matches(Class targetClass);
}
