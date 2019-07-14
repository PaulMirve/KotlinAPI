package com.example.kotlinapi.Controller

import com.example.kotlinapi.Entity.Animals
import com.example.kotlinapi.Repository.AnimalsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/animals")
class AnimalsController{
    @Autowired
    lateinit var animalsRepository: AnimalsRepository

    @PostMapping
    fun saveAnimal(@RequestBody animal: Animals): Animals{
        return animalsRepository.save(animal)
    }

    @PutMapping("/{id}")
    fun modifyAnimal(@PathVariable id:String, @RequestBody animal: Animals):Animals{
        var newAnimal = animalsRepository.findById(id)
        newAnimal.name = animal.name
        newAnimal.species = animal.species
        return animalsRepository.save(newAnimal)
    }

    @DeleteMapping("/{id}")
    fun deleteAnimal(@PathVariable id:String):String{
        var animal = animalsRepository.findById(id)
        animalsRepository.delete(animal)
        return id
    }

    @GetMapping
    fun fetchAnimals():List<Animals>{
        return  animalsRepository.findAll()
    }
}