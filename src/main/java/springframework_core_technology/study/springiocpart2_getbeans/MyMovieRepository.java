package springframework_core_technology.study.springiocpart2_getbeans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository @Primary
public class MyMovieRepository implements MovieRepository {
}
