package metatom.autumnioc;

import java.util.ArrayList;
import java.util.List;

/**
 * PropertyValues
 *
 * @author igaozp
 */
public class PropertyValues {
    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public PropertyValues() {
    }

    public void addPropertyValue(PropertyValue propertyValue) {
        this.propertyValueList.add(propertyValue);
    }

    public List<PropertyValue> getPropertyValues() {
        return this.propertyValueList;
    }
}
