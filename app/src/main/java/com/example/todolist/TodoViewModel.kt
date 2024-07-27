package com.example.todolist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.Instant
import java.util.Date

class TodoViewModel: ViewModel() {

    val todoDAO = MainApplication.todoDatabase.getTodoDao()

    val todoList : LiveData<List<Todo>> = todoDAO.getAllTodo()

// ViewModel, ответственная за логику приложения (создание и удаление записей)
    // ViewModel также служит связующим звеном между View и Model

    fun addTodo(title : String){
        viewModelScope.launch (Dispatchers.IO) {
            todoDAO.addTodo(Todo(title = title, createdAt = Date.from(Instant.now())))
        }
    }

    fun deleteTodo(id : Int){
        viewModelScope.launch (Dispatchers.IO) {
            todoDAO.deleteTodo(id)
        }
    }
}