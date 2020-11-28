package miller.al.repository;

import miller.al.model.Cat;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CatRepository extends CrudRepository<Cat, String> {
    Cat findOne(String name);

    List<Cat> findByFurColour(String furColour);
}
