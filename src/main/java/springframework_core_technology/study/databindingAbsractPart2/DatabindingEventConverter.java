package springframework_core_technology.study.databindingAbsractPart2;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import springframework_core_technology.study.databindingAbstractPart1.DataBindingEvent;


public class DatabindingEventConverter {

    @Component
    public static class StringToEventConverter implements Converter<String, DataBindingEvent> {
        @Override
        public DataBindingEvent convert(String s) {
            return new DataBindingEvent(Integer.parseInt(s));
        }
    }

    @Component
    public static class EventToStringConverter implements Converter<DataBindingEvent, String> {
        @Override
        public String convert(DataBindingEvent event) {
            return event.getId().toString();
        }
    }
}
