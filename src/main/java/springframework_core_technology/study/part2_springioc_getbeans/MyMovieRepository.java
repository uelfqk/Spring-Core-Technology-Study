package springframework_core_technology.study.part2_springioc_getbeans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository @Primary
public class MyMovieRepository implements MovieRepository {
}
