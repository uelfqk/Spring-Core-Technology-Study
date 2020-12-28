package springframework_core_technology.study.part13_databindingAbsract;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import springframework_core_technology.study.part12_databindingAbstract.DataBindingEvent;

import java.text.ParseException;
import java.util.Locale;

@Component
public class DatabindingFormatter implements Formatter<DataBindingEvent> {
    @Override
    public DataBindingEvent parse(String s, Locale locale) throws ParseException {
        return new DataBindingEvent(Integer.parseInt(s));
    }

    @Override
    public String print(DataBindingEvent event, Locale locale) {
        return event.getId().toString();
    }
}
