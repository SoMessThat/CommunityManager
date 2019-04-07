package mess.wkb.cm.tool.annotation;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * User: wangj
 * Date: 13-11-8
 * Time: 上午9:33
 */
@Target({ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Table {
    String value() default "";
}
