package springframework_core_technology.study.part5_springioc_profile;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@SpringBootTest
public class IocContainerPart5ProfileTest {

    @Autowired
    ApplicationContext ap;

    @Autowired
    TestRepository testRepository;

    @Test
    void profileTest() throws Exception {
        Environment environment = ap.getEnvironment();
        System.out.println(Arrays.toString(environment.getDefaultProfiles()));
        System.out.println(Arrays.toString(environment.getActiveProfiles()));
    }
}
