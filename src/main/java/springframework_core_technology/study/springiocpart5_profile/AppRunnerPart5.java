package springframework_core_technology.study.springiocpart5_profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class AppRunnerPart5 implements ApplicationRunner {

    @Autowired
    private ApplicationContext ap;

    // 프로파일을 test 로 지정했기 떄문에 testRepository Bean 을 찾지 못한다.
    // 별도로 어떤 프로파일을 사용할 것인지 설정해야한다.
    @Autowired
    private TestRepository testRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Environment environment = ap.getEnvironment();
        System.out.println(Arrays.toString(environment.getDefaultProfiles()));
        System.out.println(Arrays.toString(environment.getActiveProfiles()));
    }
}
