package springframework_core_technology.study.validationAbstract;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Arrays;

@SpringBootTest
public class ValidationTest {
    @Autowired
    Validator validator;

    @Test
    void validationWithValidatorClassV1Test() throws Exception {
        Event event = new Event();
        event.setTitle("title");
        EventValidator eventValidator = new EventValidator();
        // Errors 인터페이스는 스프링 MVC 를 사용할때 많이 사용할 것이다.
        // BeanPropertyBindingResult 구현체는 스프링이 주입해주기때문에 거의 사용할 일이 없을 것이다.
        Errors errors = new BeanPropertyBindingResult(event, "event");
        // Validator 에 검증하고자하는 객체와 Errors 인터페이스를 구현한 구현체를 넘겨줌
        // 이와같이 Validator 를 만드는것은 오래된 방식이다.
        eventValidator.validate(event, errors);

        printErrorsMessage(errors);

        Assertions.assertThat(errors.hasErrors()).isFalse();
    }

    @Test
    void validationWithValidatorClassV2Test() throws Exception {
        Event event = new Event();
        event.setTitle("title");
        EventValidatorV2 eventValidator = new EventValidatorV2();
        // Errors 인터페이스는 스프링 MVC 를 사용할때 많이 사용할 것이다.
        // BeanPropertyBindingResult 구현체는 스프링이 주입해주기때문에 거의 사용할 일이 없을 것이다.
        Errors errors = new BeanPropertyBindingResult(event, "event");
        // Validator 에 검증하고자하는 객체와 Errors 인터페이스를 구현한 구현체를 넘겨줌
        // 이와같이 Validator 를 만드는것은 오래된 방식이다.
        eventValidator.validate(event, errors);

        printErrorsMessage(errors);

        Assertions.assertThat(errors.hasErrors()).isFalse();
    }

    @Test
    void validationWithAnnotationv() throws Exception {
        // validator = org.springframework.validation.beanvalidation.LocalValidatorFactoryBean 을 주입 받는다.
        System.out.println("validator = " + validator.getClass());

        Event event = new Event();
        event.setId(1);
        event.setTitle("title");
        event.setEmail("shhzg_zz@naver.com");

        EventValidator eventValidator = new EventValidator();
        // Errors 인터페이스는 스프링 MVC 를 사용할때 많이 사용할 것이다.
        // BeanPropertyBindingResult 구현체는 스프링이 주입해주기때문에 거의 사용할 일이 없을 것이다.
        Errors errors = new BeanPropertyBindingResult(event, "event");

        // Validator 에 검증하고자하는 객체와 Errors 인터페이스를 구현한 구현체를 넘겨줌
        validator.validate(event, errors);

        printErrorsMessage(errors);

        Assertions.assertThat(errors.hasErrors()).isFalse();
    }

    void printErrorsMessage(Errors errors) {
        // errors.hasErrors() -> 에러의 내용이 true 인지 확인
        System.out.println("errors.hasErrors() = " + errors.hasErrors());

        errors.getAllErrors().forEach(e -> {
            System.out.println("===== error code =====");
            // 에러코드들을 받아서 출력
            // 아래와 같이 람다식을 더 줄일수 있다.
            // Arrays.stream(e.getCodes()).forEach(code -> System.out.println("code = " + code));
            Arrays.stream(e.getCodes()).forEach(System.out::println);
            // 지정해둔 기본 메시지 출력
            System.out.println("e.getDefaultMessage() = " + e.getDefaultMessage());
        });
    }
}
