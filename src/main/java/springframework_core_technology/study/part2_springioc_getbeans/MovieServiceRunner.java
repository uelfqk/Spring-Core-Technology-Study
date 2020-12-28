package springframework_core_technology.study.part2_springioc_getbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MovieServiceRunner implements ApplicationRunner {

    @Autowired
    private MovieService movieService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        movieService.printMovieRepositorys();
        System.out.println();
        movieService.printMovieRepositoryPrimary();
        System.out.println();
        movieService.printMovieRepositoryQualifier();
    }
}
