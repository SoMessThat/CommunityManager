package mess.wkb.cm.tool.util;




/**
 * 不被捕获的异常,将抛至最顶层.
 * 
 * @author yangz
 * @date 2012-7-28 下午03:07:44
 */
@SuppressWarnings("serial")
public class LoginException extends Exception {

	public LoginException() {
		super();
	}

	public LoginException(String message, Throwable cause) {
		super(message, cause);
	}

	public LoginException(String message) {
		super(message);
	}

	public LoginException(Throwable cause) {
		super(cause);
	}

}
