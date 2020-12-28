package springframework_core_technology.study.part12_databindingAbstract;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataBindingEventController {

    @InitBinder
    public void init(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(DataBindingEvent.class, new DataBindingEventEditor());
    }

    // /event/1, /event/2 등의 입력이 들어오고 이것을 바탕으로 DataBindingEvent 객체로 변환해야한다.
    @GetMapping("/event/{event}")
    public String getEvent(@PathVariable DataBindingEvent event) {
        System.out.println(event);
        return event.getId().toString();
    }
}
