package springframework_core_technology.study.springiocpart4_beanscope;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

// 스프링 빈 스코프 테스트
@SpringBootTest
public class IocContainerPart4BeanScopeTest {

    @Autowired
    Single single;
    @Autowired
    Proto proto;
    @Autowired
    ApplicationContext ap;

    @Test
    void beanScopeTestWithApplicationContext() throws Exception {
        System.out.println("Single");
        System.out.println("ap.getBean(Single.class) = " + ap.getBean(Single.class));
        System.out.println("ap.getBean(Single.class) = " + ap.getBean(Single.class));
        System.out.println("ap.getBean(Single.class) = " + ap.getBean(Single.class));
        System.out.println("Proto");
        System.out.println("ap.getBean(Single.class) = " + ap.getBean(Proto.class));
        System.out.println("ap.getBean(Single.class) = " + ap.getBean(Proto.class));
        System.out.println("ap.getBean(Single.class) = " + ap.getBean(Proto.class));
        System.out.println("Proto by Single");
        System.out.println("ap.getBean(Single.class).getProto() = " + ap.getBean(Single.class).getProto());
        System.out.println("ap.getBean(Single.class).getProto() = " + ap.getBean(Single.class).getProto());
        System.out.println("ap.getBean(Single.class).getProto() = " + ap.getBean(Single.class).getProto());
    }

    // Proto 객체는 왜 싱글톤 스코프로 주입이 됬지?
    // AutoWried 때문에 그런건가?
    @Test
    void beanScopeTestWithIoc() throws Exception {
        System.out.println("Single");
        System.out.println("single.getClass() = " + single.getClass());
        System.out.println("single.getClass() = " + single.getClass());
        System.out.println("single.getClass() = " + single.getClass());
        System.out.println("Proto");
        System.out.println("proto.getClass() = " + proto.getClass());
        System.out.println("proto.getClass() = " + proto.getClass());
        System.out.println("proto.getClass() = " + proto.getClass());
        System.out.println("Proto by Single");
        System.out.println("single.getProto().getClass() = " + single.getProto().getClass());
        System.out.println("single.getProto().getClass() = " + single.getProto().getClass());
        System.out.println("single.getProto().getClass() = " + single.getProto().getClass());
    }
}
