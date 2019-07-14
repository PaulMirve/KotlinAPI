package com.example.kotlinapi.Repository

import com.example.kotlinapi.Entity.Animals
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.io.Serializable

@Repository
interface AnimalsRepository: MongoRepository<Animals, Serializable>{
    fun findById(id: String):Animals
}