package metatom.autumnioc.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * PropertyValues Bean 的属性列表
 *
 * @author igaozp
 */
public class PropertyValues {
    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    PropertyValues() {
    }

    public void addPropertyValue(PropertyValue propertyValue) {
        this.propertyValueList.add(propertyValue);
    }

    public List<PropertyValue> getPropertyValues() {
        return this.propertyValueList;
    }
}
