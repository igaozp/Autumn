package metatom.autumnioc;

import lombok.Data;

/**
 * BeanReference Bean 的引用结构
 *
 * @author igaozp
 */
@Data
public class BeanReference {
    private String name;
    private Object bean;

    public BeanReference(String name) {
        this.name = name;
    }
}
