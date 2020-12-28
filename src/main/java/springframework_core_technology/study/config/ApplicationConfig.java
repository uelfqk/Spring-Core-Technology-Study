package springframework_core_technology.study.config;

import springframework_core_technology.study.part1_springioc.BookRepository;
import springframework_core_technology.study.part1_springioc.BookService;

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
