package mess.wkb.cm.tool.util.ajax;





import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mess.wkb.cm.tool.util.UnCaughtException;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Jackson2工具类.
 * 
 * @Company : cyou
 * @author yangz
 * @date 2012-10-10 上午09:51:50
 */
public class Jackson2Util {

	/** 日志处理器 . */
	private static Logger logger = LoggerFactory.getLogger(Jackson2Util.class);

	private static final ObjectMapper mapper = new ObjectMapper();

	static {
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
				false);

	}

	/**
	 * 采用JSON格式输出结果对象.
	 * 
	 * @param result
	 *            结果对象
	 * @throws IOException
	 */
	public static void writeJson(HttpServletResponse response, Object result) {
		PrintWriter writer = null;
		response.setContentType("text/plain; charset=UTF-8");
		try {
			writer = response.getWriter();
			String json = toJson(result);
			writer.println(json);
		} catch (Exception e) {
			throw new UnCaughtException(e);
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}

	/**
	 * 将对象转化为Json格式字符串.
	 * 
	 * @param obj
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonGenerationException
	 */
	public static String toJson(Object obj) {
		try {
			return mapper.writeValueAsString(obj);
		} catch (Exception e) {
			throw new UnCaughtException(e);
		}
	}

	/**
	 * 将Json格式字符串转化为对象.
	 * 
	 * @param <T>
	 * @param json
	 * @param requiredType
	 * @return
	 */
	public static <T> T toObject(String json, Class<T> requiredType) {
		try {
			return mapper.readValue(json, requiredType);
		} catch (Exception ex) {
			logger.error("JSON字符串转VO对象报错，字符串：\n" + json);
			throw new UnCaughtException(ex.getMessage());
		}
	}

	/**
	 * 将Json格式字符串转化为对象.
	 * 
	 * @param <T>
	 * @param json
	 * @param requiredType
	 * @return
	 */
	public static <T> T toObject(String json, TypeReference<T> type) {
		try {
			return mapper.readValue(json, type);
		} catch (Exception ex) {
			throw new UnCaughtException(ex.getMessage());
		}
	}

}
