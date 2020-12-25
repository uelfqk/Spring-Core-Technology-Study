package springframework_core_technology.study.config;

import springframework_core_technology.study.springiocpart1.BookRepository;
import springframework_core_technology.study.springiocpart1.BookService;

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
