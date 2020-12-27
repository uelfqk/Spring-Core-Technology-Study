package springframework_core_technology.study.databindingAbsractPart2;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Spring-boot 를 사용하지 않고 Spring 만 사용하는 경우
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        // Convert 정보 등록
//        registry.addConverter(new DatabindingEventConverter.StringToEventConverter());
//        // Formatter 정보 등록
//        registry.addFormatter(new DatabindingFormatter());
//    }
//}
public class WebConfig {

}