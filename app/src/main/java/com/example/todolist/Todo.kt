package com.example.todolist

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

// Сущность, необходимая для взаимодействия с базой данных в Room
// Всё, что связвано с работой базы данных - уровень Model в паттерне MVVM

@Entity
data class Todo(
    @PrimaryKey(autoGenerate = true)
    var id: Int =0,
    var title: String,
    var createdAt: Date
)