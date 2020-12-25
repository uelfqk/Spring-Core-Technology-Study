package springframework_core_technology.study.springiocpart1;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book save(Book book) {
        book.setCreated(LocalDateTime.now());
        book.setBookStatus(BookStatus.DRAFT);
        return bookRepository.save(book);
    }
}
