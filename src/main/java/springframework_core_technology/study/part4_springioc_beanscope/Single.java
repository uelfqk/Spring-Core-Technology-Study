package springframework_core_technology.study.part4_springioc_beanscope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Single {
//    @Autowired
//    private ObjectProvider<Proto> proto;
//
//    // ObjectProvider 를 사용하는 방법
//    // 자바 코드에 스프링 코드가 들어가기 때문에 추천하지 않는다.
//    // 차라리 Bean 선언하는 부분에만 처리하는 것이 조금 더 POJO 스럽게 코딩하는 방법인것같다.
//    public Proto getProto() {
//        return proto.getIfAvailable();
//    }

    @Autowired
    private Proto proto;

    public Proto getProto() {
        return proto;
    }
}
