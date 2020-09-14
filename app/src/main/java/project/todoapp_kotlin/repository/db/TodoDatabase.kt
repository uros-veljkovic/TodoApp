package project.todoapp_kotlin.repository.db

import androidx.room.Database
import androidx.room.RoomDatabase
import project.todoapp_kotlin.repository.dao.TodoDao
import project.todoapp_kotlin.repository.entity.TodoEntity

@Database(
    entities = [TodoEntity::class],
    version = 1,
    exportSchema = false
)
abstract class TodoDatabase : RoomDatabase() {

    abstract fun todoDao(): TodoDao

    companion object {
        val DATABASE_NAME: String = "todo_db"
    }
}