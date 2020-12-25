package springframework_core_technology.study.book;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class Book {
    private LocalDateTime created;
    private BookStatus bookStatus;

}
