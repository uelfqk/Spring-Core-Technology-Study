package springframework_core_technology.study.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

//@Service
public class ProxySimpleEventService implements EventService {
    private final SimpleEventService simpleEventService;

    public ProxySimpleEventService(SimpleEventService simpleEventService) {
        this.simpleEventService = simpleEventService;
    }

    @Override
    public void createEvent() {
        long begin = System.currentTimeMillis();
        simpleEventService.createEvent();
        System.out.println(System.currentTimeMillis() - begin + " ms");
    }

    @Override
    public void publishEvent() {
        long begin = System.currentTimeMillis();
        simpleEventService.publishEvent();
        System.out.println(System.currentTimeMillis() - begin + " ms");
    }

    @Override
    public void deleteEvent() {
        simpleEventService.deleteEvent();
    }
}
