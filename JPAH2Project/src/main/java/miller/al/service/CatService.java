package miller.al.service;

import miller.al.model.Cat;
import miller.al.model.EyeColour;
import miller.al.model.FurColour;
import miller.al.repository.CatRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CatService {

    private final CatRepository catRepository;

    CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    void createNewCat(String name, Integer age, EyeColour eyeColour, FurColour furColour) {
        Cat newCat = Cat.builder().age(age).eyeColour(eyeColour).furColour(furColour).name(name).build();
        catRepository.createOne(newCat);
    }

    void updateNewCat(String name, Integer age, EyeColour eyeColour, FurColour furColour) {
        Cat newCat = Cat.builder().age(age).eyeColour(eyeColour).furColour(furColour).name(name).build();
        catRepository.updateOne(newCat);
    }

    Optional<Cat> getCatByName(String name) {
        return Optional.ofNullable(catRepository.findOneByName(name));
    }

    void deleteCatByName(String name) {
        catRepository.deleteOneByName(name);
    }
}
