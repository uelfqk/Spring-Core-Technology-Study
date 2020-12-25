package springframework_core_technology.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springframework_core_technology.study.book.BookRepository;
import springframework_core_technology.study.book.BookService;

//@Configuration
public class ApplicationConfig {

    //@Bean
    public BookRepository bookRepository() {
        return new BookRepository();
    }

    //@Bean
    public BookService bookService() {
        return new BookService(bookRepository());
    }
}
