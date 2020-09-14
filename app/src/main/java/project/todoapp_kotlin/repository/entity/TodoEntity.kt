package project.todoapp_kotlin.repository.entity

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Timestamp
import javax.inject.Inject

@Entity(tableName = "todo_table")
data class TodoEntity
constructor(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val _id: Long?,
    val _text: String,
    val _inCharge: String,
    val _dateInMillis: Long
) {

}