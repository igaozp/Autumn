package metatom.autumnioc.beans.io;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * ResourceLoaderTest
 *
 * @author igaozp
 */
public class ResourceLoaderTest {
    /**
     * 测试能否加载配置文件
     *
     * @throws IOException IO 异常
     */
    @Test
    public void test() throws IOException {
        ResourceLoader resourceLoader = new ResourceLoader();
        Resource resource = resourceLoader.getResource("autumnioc.xml");
        InputStream inputStream = resource.getInputStream();
        Assert.assertNotNull(inputStream);
    }
}