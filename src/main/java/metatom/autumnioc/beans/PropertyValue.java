package metatom.autumnioc.beans;

/**
 * PropertyValue Bean 的属性值
 *
 * @author igaozp
 */
public class PropertyValue {
    private final String name;
    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
