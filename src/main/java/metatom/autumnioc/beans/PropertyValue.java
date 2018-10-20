package metatom.autumnioc.beans;

import lombok.Getter;

/**
 * PropertyValue Bean 的属性值
 *
 * @author igaozp
 */
@Getter
public class PropertyValue {
    private final String name;
    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }
}
