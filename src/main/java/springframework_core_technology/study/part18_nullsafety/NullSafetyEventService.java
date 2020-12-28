package springframework_core_technology.study.part18_nullsafety;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class NullSafetyEventService {

    // Spring Data Project 와 Spring Reactive Project 에서도 지원
    // 기본설정이 되어있지 않음으로 아래와 같이 설정 필요
    // IntelliJ 기준 -> Settings -> Compiler -> Configure Annotations
    // Nullable -> @Nullable (org.springframework.lang) 추가
    // NotNull  -> @NonNull (org.springframework.lang) 추가

    // 위와 같이 설정하여도 매개변수에 null 값을 넣었을때 컴파일에러 발생하지 않음
    // 코드를 실행하여도 null 값이 넘어간채로 실행
    @NonNull
    public String createEvent(@NonNull String name) {
        return "hello" + name;
    }

    // 코드를 실행하여도 null 값을 반환
    @NonNull String createEventV2(String name) {
        return null;
    }

    // 매개 변수나 반환 값에 마우스를 가져다 대었을때 tooltip 으로 안내만 가능한것같음
}
