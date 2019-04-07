package mess.wkb.cm.tool.cache;

import mess.wkb.cm.tool.util.SpringContextLoader;








/**
 * 缓存管理.
 * @author Aioria
 */
public class CacheHandle {

	/**
	 * 获取缓存代理.
	 * 
	 * @return
	 */
	public static ISimpleCacheProxy getCacheProxy() {
		return (ISimpleCacheProxy) SpringContextLoader.getBean("cacheProxy");
	}

}
