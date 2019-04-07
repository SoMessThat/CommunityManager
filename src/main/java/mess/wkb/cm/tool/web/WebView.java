package mess.wkb.cm.tool.web;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.view.JstlView;
 



public class WebView extends JstlView {

	@Override
	protected void initServletContext(ServletContext servletContext) {
		super.initServletContext(servletContext);
	}

	@Override
	protected void exposeHelpers(HttpServletRequest request) throws Exception {
		setModel(request);
	}
	
	public static void setModel(HttpServletRequest request) {
		
		
	}
	
}
