package springframework_core_technology.study.databindingAbstractPart1;

import java.beans.PropertyEditorSupport;

public class DataBindingEventEditor extends PropertyEditorSupport {

    // getValue(), setValue() 는 상태값을 가지고 있기때문에 stateful
    // 스레드로부터 안전하지 않다.
    // 절대로 빈으로 등록해서 사용하면 안된다. @Component X
    // 한 스레드내에서만 유효한 Thread Scope 로 등록하면 괜찮지만 왠만하면 빈으로 등록하지 않는것이 좋다.

    // 방법이 편리하지도 않고 스레드로부터 안전하지 않아 잘 사용하지 않는다.

    @Override
    public String getAsText() {
        DataBindingEvent event = (DataBindingEvent) getValue();
        return super.getAsText();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(new DataBindingEvent(Integer.parseInt(text)));
    }
}
