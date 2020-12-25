package springframework_core_technology.study.springiocpart2;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public class MyMovieRepository implements MovieRepository {
}
