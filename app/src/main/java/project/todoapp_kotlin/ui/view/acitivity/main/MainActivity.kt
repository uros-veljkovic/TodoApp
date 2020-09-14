package project.todoapp_kotlin.ui.view.acitivity.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import project.fragments.todoapp_kotlin.databinding.ActivityMainBinding
import project.todoapp_kotlin.repository.entity.TodoEntity
import project.todoapp_kotlin.ui.view.acitivity.main.adapter.TodoListRecyclerViewAdapter
import project.todoapp_kotlin.ui.viewmodel.TodoListViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: TodoListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()

        viewModel.todoList.observe(this, {
            if (it != null) binding.adapter?.setTodoList(it)
        })
    }

    private fun initBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.adapter = TodoListRecyclerViewAdapter(arrayListOf<TodoEntity>())
    }
}