package metatom.autumnioc.beans.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Resource
 *
 * @author igaozp
 */
public interface Resource {
    /**
     * 获取资源的输入流
     *
     * @return 资源的输入流
     * @throws IOException IO 异常
     */
    InputStream getInputStream() throws IOException;
}
