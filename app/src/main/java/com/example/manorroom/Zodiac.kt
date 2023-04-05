package com.example.manorroom

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Zodiac(
    @PrimaryKey val id: UUID,
    val name: String,
    val description: String,
    val symbol: String,
    val month: String
)