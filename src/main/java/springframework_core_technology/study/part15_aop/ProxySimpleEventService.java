package springframework_core_technology.study.part15_aop;

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
