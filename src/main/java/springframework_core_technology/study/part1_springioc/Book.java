package springframework_core_technology.study.part1_springioc;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class Book {
    private LocalDateTime created;
    private BookStatus bookStatus;

}
