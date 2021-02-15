package miller.al.repository;

import miller.al.model.Cat;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CatRepository extends CrudRepository<Cat, String> {
    void createOne(Cat cat);

    Cat findOneByName(String name);

    List<Cat> findByFurColour(String furColour);

    void updateOne(Cat cat);

    void deleteOne(Cat cat);

    void deleteOneByName(String name);
}
