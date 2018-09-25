package metatom.autumnioc.io;

import java.net.URL;

/**
 * ResourceLoader
 *
 * @author igaozp
 */
public class ResourceLoader {
    public Resource getResource(String location) {
        URL resource = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resource);
    }
}
