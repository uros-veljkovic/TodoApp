package project.todoapp_kotlin.repository

import androidx.lifecycle.LiveData
import dagger.Provides
import project.todoapp_kotlin.repository.dao.TodoDao
import project.todoapp_kotlin.repository.entity.TodoEntity

class Repository (
    val todoDao: TodoDao
){

    fun getTodosSortedBy(fieldName: String): LiveData<List<TodoEntity>>
            = todoDao.getAllTodosSortedBy(fieldName)

    suspend fun insert(todoEntity: TodoEntity) = todoDao.insert(todoEntity)
    suspend fun update(todoEntity: TodoEntity) = todoDao.update(todoEntity)
    suspend fun delete(todoEntity: TodoEntity) = todoDao.delete(todoEntity)
}