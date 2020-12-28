package springframework_core_technology.study.part15_aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SimpleEventServiceTest {

    @Autowired
    EventService eventService;

    @Test
    void proxyPattenTest() throws Exception {
        eventService.createEvent();
        eventService.publishEvent();
        eventService.deleteEvent();
    }
}