package net.tirgan.graphql.controller;

import net.tirgan.graphql.entity.Dog;
import net.tirgan.graphql.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {

    private DogService dogService;

    @Autowired
    public void setDogService(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/dog")
    public ResponseEntity<List<Dog>> listAllDogs() {
        List<Dog> dogList = dogService.retrieveDogs();
        return new ResponseEntity<List<Dog>>(dogList, HttpStatus.OK);
    }

}
