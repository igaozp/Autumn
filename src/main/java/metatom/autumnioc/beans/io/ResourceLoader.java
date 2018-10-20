package metatom.autumnioc.beans.io;

import java.net.URL;

/**
 * ResourceLoader 资源加载器
 *
 * @author igaozp
 */
public class ResourceLoader {
    /**
     * 通过指定的路径获取资源
     *
     * @param location 资源的路径
     * @return 路径指定的资源实例
     */
    public Resource getResource(String location) {
        URL resource = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resource);
    }
}
