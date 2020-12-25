package springframework_core_technology.study.springiocpart2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MovieService {
    @Autowired
    private Map<String, MovieRepository> MovieRepositorys;

    // @Primary 가 선언되어있는 객체 타입 주입
    @Autowired
    private MovieRepository movieRepositoryPrimary;

    // @Qualifier 의 선언된 빈이름으로 객체 타입을 찾아서 주입
    @Autowired @Qualifier(value = "otherMovieRepository")
    private MovieRepository movieRepositoryQualifier;

    public void printMovieRepositoryPrimary() {
        System.out.println("movieRepositoryPrimary = " + movieRepositoryPrimary);
    }

    public void printMovieRepositoryQualifier() {
        System.out.println("movieRepositoryQualifier = " + movieRepositoryQualifier);
    }

    public void printMovieRepositorys() {
        MovieRepositorys.forEach((k, v) -> {
            System.out.println("k = " + k + " v = " + v);
        });
    }
}
