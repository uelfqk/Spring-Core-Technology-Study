package springframework_core_technology.study.aop;

import org.springframework.stereotype.Service;

@Service
public class SimpleEventService implements EventService {
    @Override
    @PerfLogging
    public void createEvent() {
        try {
            Thread.sleep(1000);
        } catch(Exception e) {
            System.out.println("e = " + e);
        }
        System.out.println("Created an Event");
    }

    @Override
    @PerfLogging
    public void publishEvent() {
        try {
            Thread.sleep(1000);
        } catch(Exception e) {
            System.out.println("e = " + e);
        }
        System.out.println("Published an Event");
    }

    @Override
    public void deleteEvent() {
        System.out.println("Deleted an Event");
    }
}
