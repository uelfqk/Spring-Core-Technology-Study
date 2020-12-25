package springframework_core_technology.study.springiocpart3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.GenericApplicationContext;

@SpringBootApplication
public class StudyApplicationPart3 {
    public static void main(String[] args) {
        // 이와같이 하면 구동시점에 Bean 들을 등록하는 시간을 줄일 수 있다.
        // 스프링 빈을 등록할때 사용하는 리플랙션과 CGLibrary, Proxy 등을 사용하지 않기 때문
        SpringApplication app = new SpringApplication(StudyApplicationPart3.class);
        app.addInitializers((ApplicationContextInitializer<GenericApplicationContext>) ctx -> {
            ctx.registerBean(ApplicationRunner.class, () -> args1 -> {
                System.out.println("Functional Bean Definition!!");
            });
        });
        app.run(args);
    }
}
