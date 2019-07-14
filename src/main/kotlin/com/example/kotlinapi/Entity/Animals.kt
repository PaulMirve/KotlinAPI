package com.example.kotlinapi.Entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Animals(
        @Id
        var id: String,
        var species: String,
        var name: String
)