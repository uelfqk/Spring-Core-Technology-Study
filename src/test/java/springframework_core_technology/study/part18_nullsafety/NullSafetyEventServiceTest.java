package springframework_core_technology.study.part18_nullsafety;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NullSafetyEventServiceTest {

    @Autowired
    NullSafetyEventService nullSafetyEventService;

    @Test
    void nullSafetyTest() throws Exception {
        String event = nullSafetyEventService.createEvent(null);
        System.out.println("event = " + event);

    }
}