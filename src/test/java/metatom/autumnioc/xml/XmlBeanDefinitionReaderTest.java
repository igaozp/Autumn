package metatom.autumnioc.xml;

import metatom.autumnioc.BeanDefinition;
import metatom.autumnioc.io.ResourceLoader;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * XmlBeanDefinitionReaderTest
 *
 * @author igaozp
 */
public class XmlBeanDefinitionReaderTest {
    @Test
    public void test() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("autumnioc.xml");
        Map<String, BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();
        Assert.assertTrue(registry.size() > 0);
    }
}
