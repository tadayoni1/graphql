package net.tirgan.graphql.service;

import net.tirgan.graphql.entity.Dog;

import java.util.List;

public interface DogService {
    List<Dog> retrieveDogs();
}
