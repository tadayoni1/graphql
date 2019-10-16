package net.tirgan.graphql.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import net.tirgan.graphql.entity.Dog;
import net.tirgan.graphql.exception.BreedNotFoundException;
import net.tirgan.graphql.exception.DogNotFoundException;
import net.tirgan.graphql.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {

    private DogRepository dogRepository;

    public Mutation(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Dog newDog(String name, String breed, String origin) {
        Dog dog = new Dog(name, breed, origin);
        dogRepository.save(dog);
        return dog;
    }

    public boolean deleteDogBreed(String breed) {
        boolean isDeleted = false;
        Iterable<Dog> allDogs = dogRepository.findAll();
        for (Dog dog : allDogs) {
            if (dog.getBreed().equals(breed)) {
                dogRepository.deleteById(dog.getId());
                isDeleted = true;
            }
        }

        if (!isDeleted) {
            throw new BreedNotFoundException("Breed Not Found", breed);
        }

        return isDeleted;
    }

    public Dog updateDogName(String newName, long id) {

        Optional<Dog> optionalDog = dogRepository.findById(id);

        if (optionalDog.isPresent()) {
            Dog dog = optionalDog.get();
            dog.setName((newName));
            dogRepository.save(dog);
            return dog;
        } else {
            throw new DogNotFoundException("Dog Not Found", id);
        }
    }

}
