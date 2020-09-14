package project.todoapp_kotlin.binding.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import project.todoapp_kotlin.ui.view.acitivity.main.adapter.TodoListRecyclerViewAdapter

@BindingAdapter(value = ["app:adapter"])
fun RecyclerView.bindAdapter(adapter: TodoListRecyclerViewAdapter) {
    this.run {
        this.layoutManager = LinearLayoutManager(context)
        this.setHasFixedSize(true)
        this.adapter = adapter
    }
}
