package project.todoapp_kotlin.ui.view.acitivity.main.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import project.fragments.todoapp_kotlin.R
import project.fragments.todoapp_kotlin.databinding.FragmentListBinding
import project.todoapp_kotlin.repository.entity.TodoEntity
import project.todoapp_kotlin.ui.view.acitivity.main.adapter.TodoListRecyclerViewAdapter
import project.todoapp_kotlin.ui.viewmodel.TodoListViewModel
import javax.inject.Inject

@AndroidEntryPoint
class ListFragment : Fragment() {

    private lateinit var navController : NavController
    private lateinit var binding : FragmentListBinding
    private val viewModel: TodoListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListBinding.inflate(inflater, container, false)
        binding.adapter = TodoListRecyclerViewAdapter(arrayListOf())

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        observeDatabase()
    }

    private fun observeDatabase() {
        viewModel.todoList.observe(viewLifecycleOwner, {
            it?.let {
                binding.adapter?.setTodoList(it)
            }
        })
    }

}