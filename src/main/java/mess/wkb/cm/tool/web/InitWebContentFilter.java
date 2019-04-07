package mess.wkb.cm.tool.web;



import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 初始化web请求容器过滤器.
 * 
 * @author yangz
 * @date 2013-4-8 下午5:37:38
 */
public class InitWebContentFilter implements Filter {
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try {
			WebContext.setRequest((HttpServletRequest) request);
			WebContext.setResponse((HttpServletResponse) response);
			chain.doFilter(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			WebContext.remove();
		}
	}
	public void destroy() {
	}
}
