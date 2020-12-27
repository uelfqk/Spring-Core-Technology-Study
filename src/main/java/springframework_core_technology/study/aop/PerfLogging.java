package springframework_core_technology.study.aop;

import java.lang.annotation.*;

/*
 * 이 애노테이션을 사용하면 성능이 로깅됩니다.
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
public @interface PerfLogging {
}
