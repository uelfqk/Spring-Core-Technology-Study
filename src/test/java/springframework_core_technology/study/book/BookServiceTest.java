package springframework_core_technology.study.book;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springframework_core_technology.study.config.ApplicationConfig;
import springframework_core_technology.study.springiocpart1.Book;
import springframework_core_technology.study.springiocpart1.BookRepository;
import springframework_core_technology.study.springiocpart1.BookService;
import springframework_core_technology.study.springiocpart1.BookStatus;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class BookServiceTest {

    @Mock
    BookRepository bookRepository;

    @Test
    void saveTest() throws Exception {
        Book book = new Book();

        // save 메소드가 호출할때 book 을 리턴하라 => 동일한 객체를 리턴하라.
        // BookService -> bookRepository.save(book) -> Parameter 로 받은 객체를 그대로 반환
        // 이런 목 객체로 테스트가 통과할 수 있다.
        when(bookRepository.save(book)).thenReturn(book);
        BookService bookService = new BookService(bookRepository);

        Book result = bookService.save(book);

        assertThat(result).isNotNull();
        assertThat(result.getCreated()).isNotNull();
        assertThat(result.getBookStatus()).isEqualTo(BookStatus.DRAFT);
    }

    @Test
    void getBeanTest() throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        System.out.println("beanDefinitionName = " + Arrays.toString(beanDefinitionNames));
    }
}