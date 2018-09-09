package metatom.autumnioc.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Resource
 *
 * @author igaozp
 */
public interface Resource {
    /**
     * @return 输入流
     * @throws IOException IO 异常
     */
    InputStream getInputStream() throws IOException;
}
