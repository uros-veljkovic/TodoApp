package project.todoapp_kotlin.repository.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import project.todoapp_kotlin.repository.entity.TodoEntity

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(todoEntity: TodoEntity)

    @Delete
    suspend fun delete(todoEntity: TodoEntity)

    @Update
    suspend fun update(todoEntity: TodoEntity)

    @Query("SELECT * FROM todo_table ORDER BY :fieldName")
    fun getAllTodosSortedBy(fieldName: String) : LiveData<List<TodoEntity>>

}