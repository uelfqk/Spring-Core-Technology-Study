package springframework_core_technology.study.part4_springioc_beanscope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class AppRunnerPart4 implements ApplicationRunner {
    @Autowired
    ApplicationContext ap;

    @Override
    public void run(ApplicationArguments args) throws Exception {
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

/*
    @Autowired
    private Single single;

    @Autowired
    private Proto proto;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 두 객체는 싱글톤 스코프로 만들어져 있기 때문에 같은 객체이다.
        System.out.println("single = " + single.getProto());
        System.out.println("proto = " + proto);
    }
*/
}
