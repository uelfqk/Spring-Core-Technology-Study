package springframework_core_technology.study.springiocpart2_getbeans;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IocContainerPart2getBeans {
    @Autowired
    MovieService movieService;

    @Test
    void getBeanTest() {
        movieService.printMovieRepositorys();
        System.out.println();
        movieService.printMovieRepositoryPrimary();
        System.out.println();
        movieService.printMovieRepositoryQualifier();
    }
}
