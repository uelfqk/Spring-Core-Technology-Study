package springframework_core_technology.study.part5_springioc_profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
//@Profile(value = "test")
@Profile(value = "!prod")
public class TestBookRepository implements TestRepository {
}
