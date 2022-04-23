package com.example.demo.controller;

import com.example.demo.entity.Hero;
import com.example.demo.repository.HeroRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("heroes")
public class HeroController {

    @Autowired
    private HeroRepository repository;

    @GetMapping("")
    public List<Hero> allHeroes() {
        return (List<Hero>) repository.findAll();
    }

    @PostMapping("")
    ResponseEntity<Hero> create(@RequestBody Hero hero) {
        return ResponseEntity.ok(repository.save(hero));
    }

    @DeleteMapping("")
    void delete(@RequestParam(required = true) Long id) {
        repository.delete(repository.findById(id).get());
    }

    @GetMapping(path = "?={name}")
    public List<Hero> findHeroByName(@PathVariable("name") String name) {    
        return repository.findByName(name);
    }

    @GetMapping(path = "?={id}")
    public Hero getHero(@PathVariable long id) {
        return repository.findById(id).get();
    }
    
}