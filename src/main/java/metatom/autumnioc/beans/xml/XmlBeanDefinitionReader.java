package metatom.autumnioc.beans.xml;

import metatom.autumnioc.beans.AbstractBeanDefinitionReader;
import metatom.autumnioc.beans.BeanDefinition;
import metatom.autumnioc.BeanReference;
import metatom.autumnioc.beans.PropertyValue;
import metatom.autumnioc.beans.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 * XmlBeanDefinitionReader
 *
 * @author igaozp
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {
    public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(String location) throws Exception {
        InputStream inputStream = getResourceLoader().getResource(location).getInputStream();
        doLoadBeanDefinitions(inputStream);
    }

    /**
     * 加载 Bean 的定义结构
     *
     * @param inputStream 定义 Bean 结构的资源输入流
     * @throws Exception IO 异常 | 解析异常 | 参数异常
     */
    private void doLoadBeanDefinitions(InputStream inputStream) throws Exception {
        // 生成 Document 对象
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document = documentBuilder.parse(inputStream);

        registerBeanDefinitions(document);

        inputStream.close();
    }

    /**
     * 注册 Bean 的定义结构
     *
     * @param document 定义 Bean 的文档对象
     */
    private void registerBeanDefinitions(Document document) {
        Element root = document.getDocumentElement();
        parseBeanDefinitions(root);
    }

    /**
     * 解析 Bean 的定义结构
     *
     * @param root DOM 的根节点
     */
    private void parseBeanDefinitions(Element root) {
        // 获取所有子节点
        NodeList nodeList = root.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                Element element = (Element) node;
                // 处理相关的节点
                processBeanDefinition(element);
            }
        }
    }

    /**
     * 完成 XML 中 bean 标签的处理，
     * 依次完成： Bean 的基本信息解析 -> Bean 的属性解析和设置 -> Bean 的注册
     *
     * @param element DOM 节点
     */
    private void processBeanDefinition(Element element) {
        // 获取文档标签中 id 和 class 属性的值
        String name = element.getAttribute("id");
        String className = element.getAttribute("class");

        // 创建 BeanDefinition 对象，完成属性的设置
        BeanDefinition beanDefinition = new BeanDefinition();
        processProperty(element, beanDefinition);
        beanDefinition.setBeanClassName(className);

        // 完成注册
        getRegistry().put(name, beanDefinition);
    }

    /**
     * Bean property 标签下属性的解析和赋值处理，
     * 解析出 property 标签下的属性 name 和 value 或者 ref，
     * 并将属性赋值给 BeanDefinition 实例。
     *
     * @param element        DOM 节点
     * @param beanDefinition Bean 的定义结构
     */
    private void processProperty(Element element, BeanDefinition beanDefinition) {
        // 获取所有的 property 属性标签
        NodeList propertyNode = element.getElementsByTagName("property");

        for (int i = 0; i < propertyNode.getLength(); i++) {
            Node node = propertyNode.item(i);
            if (node instanceof Element) {
                Element propertyElement = (Element) node;

                // 获取 name 和 value 的属性值
                String name = propertyElement.getAttribute("name");
                String value = propertyElement.getAttribute("value");

                if (value != null && value.length() > 0) {
                    // 设置属性名称和属性值
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, value));
                } else {
                    // 获取 ref 引用
                    String ref = propertyElement.getAttribute("ref");
                    if (ref == null || ref.length() == 0) {
                        // property 标签没有指定 ref 和 value 的值
                        throw new IllegalArgumentException("Configuration problem: <property> element for property '"
                                + name + "' must specify a ref or value");
                    }

                    // 设置属性名称和引用
                    BeanReference beanReference = new BeanReference(ref);
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, beanReference));
                }
            }
        }
    }
}
