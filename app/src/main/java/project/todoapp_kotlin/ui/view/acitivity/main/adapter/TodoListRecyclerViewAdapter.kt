package project.todoapp_kotlin.ui.view.acitivity.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import project.fragments.todoapp_kotlin.databinding.TodoListItemBinding
import project.todoapp_kotlin.repository.entity.TodoEntity

class TodoListRecyclerViewAdapter(
    private var todoList: List<TodoEntity>
): RecyclerView.Adapter<TodoListRecyclerViewAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TodoListItemBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(todoList[position])
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    fun setTodoList(list: List<TodoEntity>){
        this.todoList = list
    }

    inner class ViewHolder(
        val binding: TodoListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(todo: TodoEntity){
            binding.todoEntity = todo
            binding.executePendingBindings()
        }

    }
}