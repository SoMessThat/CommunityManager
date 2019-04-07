package mess.wkb.cm.tool.web;




import java.sql.Timestamp;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;


public class BindingInitializer implements WebBindingInitializer{

	public void initBinder(WebDataBinder binder, WebRequest request) {
		binder.registerCustomEditor(Timestamp.class, new CustomTimestampEditor("yyyy-MM-dd HH:mm:ss",true));
		binder.registerCustomEditor(String.class, new StringEditor());
	}

}
