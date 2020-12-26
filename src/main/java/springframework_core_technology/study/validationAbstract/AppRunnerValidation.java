package springframework_core_technology.study.validationAbstract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Arrays;

@Component
public class AppRunnerValidation implements ApplicationRunner {

    // Validator 를 직접 주입받아 사용
    // 애노테이션으로 검증할 수 있는 내용들은 Validation 의존성을 받아 처리하면되고
    // 복잡한 비즈니스 로직의 검증은 별도의 Validator 객체를 만들어 처리하는것이 좋다.
    @Autowired
    private Validator validator;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("validator = " + validator.getClass());

        Event event = new Event();

        event.setId(-1);
        event.setEmail("shhzg_zz@naver.com");

        EventValidator eventValidator = new EventValidator();
        // Errors 인터페이스는 스프링 MVC 를 사용할때 많이 사용할 것이다.
        // BeanPropertyBindingResult 구현체는 스프링이 주입해주기때문에 거의 사용할 일이 없을 것이다.
        Errors errors = new BeanPropertyBindingResult(event, "event");
        // Validator 에 검증하고자하는 객체와 Errors 인터페이스를 구현한 구현체를 넘겨줌
        // 이와같이 Validator 를 만드는것은 오래된 방식이다.
        //eventValidator.validate(event, errors);
        validator.validate(event, errors);
        // errors.hasErrors() -> 에러의 내용이 true 인지 확인
        System.out.println("errors.hasErrors() = " + errors.hasErrors());

        errors.getAllErrors().forEach(e -> {
            System.out.println("===== error code =====");
            // 에러코드들을 받아서 출력
            Arrays.stream(e.getCodes()).forEach(System.out::println);
            // 지정해둔 기본 메시지 출력
            System.out.println("e.getDefaultMessage() = " + e.getDefaultMessage());
        });
    }
}
