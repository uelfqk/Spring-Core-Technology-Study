package springframework_core_technology.study.part11_validationAbstract;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class EventValidatorV2 implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Event.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Event event = (Event)o;
        if(event.getTitle() == null) {
            // 특정 필드 값이 아닌 전반적인 내용이기때문에 reject 사용
            errors.reject("notEmpty");
        }
    }
}
