package springframework_core_technology.study.databindingAbstractPart1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.convert.ConversionService;
import org.springframework.test.web.servlet.MockMvc;
import springframework_core_technology.study.databindingAbsractPart2.DatabindingEventConverter;
import springframework_core_technology.study.databindingAbsractPart2.DatabindingFormatter;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest({
        DatabindingFormatter.class,
        DataBindingEventController.class
})
class DataBindingEventControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ConversionService conversionService;

    // databindingAbsractPart1, Part2 테스트
    @Test
    void getTest() throws Exception {
        mockMvc.perform(get("/event/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }

    @Test
    void conversionServiceTest() throws Exception {
        // 스프링 부트를 사용하면 DefaultFormattingConversionService 를 상속받아 만든
        // WebConversionService 을 주입하여 준다.
        System.out.println("conversionService = " + conversionService.getClass());
    }
}