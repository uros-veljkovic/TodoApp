package project.todoapp_kotlin.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import project.todoapp_kotlin.model.TodoObservable
import project.todoapp_kotlin.repository.Repository
import project.todoapp_kotlin.repository.entity.TodoEntity
import java.util.*

class TodoListViewModel
@ViewModelInject
constructor(
    val repository: Repository,
    var todoList: MutableLiveData<List<TodoEntity>>,
    var todoItem: TodoObservable
) : ViewModel() {

    @ExperimentalCoroutinesApi
    suspend fun insertItem() {
        viewModelScope.launch {
            repository.insert(todoItem.toEntity())
        }
    }

    @ExperimentalCoroutinesApi
    suspend fun updateItem() {
        viewModelScope.launch {
            repository.update(todoItem.toEntity())
        }
    }

    @ExperimentalCoroutinesApi
    suspend fun deleteItem() {
        viewModelScope.launch {
            repository.delete(todoItem.toEntity())
        }
    }
    @ExperimentalCoroutinesApi
    fun getAll(): LiveData<List<TodoEntity>> {
        viewModelScope.launch(IO) {
            todoList = repository.getTodosSortedBy(TodoEntity::_dateInMillis.name) as MutableLiveData<List<TodoEntity>>
        }
        return todoList
    }

/*    @ExperimentalCoroutinesApi
    suspend fun insert(todoEntity: TodoEntity) {
        viewModelScope.launch {
            repository.insert(todoEntity)
        }
    }

    @ExperimentalCoroutinesApi
    suspend fun update(todoEntity: TodoEntity) {
        viewModelScope.launch {
            repository.update(todoEntity)
        }
    }

    @ExperimentalCoroutinesApi
    suspend fun delete(todoEntity: TodoEntity) {
        viewModelScope.launch {
            repository.delete(todoEntity)
        }
    }
    @ExperimentalCoroutinesApi
    fun getAll(): LiveData<List<TodoEntity>> {
        viewModelScope.launch(IO) {
            todoList = repository.getTodosSortedBy(TodoEntity::dateInMillis.name) as MutableLiveData<List<TodoEntity>>
        }
        return todoList
    }*/
}

fun TodoObservable.toEntity() : TodoEntity{
    return TodoEntity(
        _id = null,
        _text = this.text.toString(),
        _inCharge = this.inCharge.toString(),
        _dateInMillis = Date().time
    )
}