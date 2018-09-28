package metatom.autumnioc.aop;

/**
 * ClassFilter
 *
 * @author igaozp
 */
public interface ClassFilter {
    boolean matches(Class targetClass);
}
