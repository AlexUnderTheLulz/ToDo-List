package com.example.todolist.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todolist.Todo

// DAO (Data Access Object) - объект доступа к данным, предоставляет способ доступа к данным,
// хранящимся в базе данных

@Dao
interface TodoDAO {

   @Query ("SELECT * FROM TODO")
    fun getAllTodo () : LiveData<List<Todo>>

    @Insert
    fun addTodo (todo: Todo)

    @Query("DELETE FROM Todo WHERE id = :id")
    fun deleteTodo(id: Int)
}