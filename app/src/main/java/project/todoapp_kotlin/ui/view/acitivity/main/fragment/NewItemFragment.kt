package project.todoapp_kotlin.ui.view.acitivity.main.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import project.fragments.todoapp_kotlin.R
import project.fragments.todoapp_kotlin.databinding.FragmentListBinding
import project.fragments.todoapp_kotlin.databinding.FragmentNewItemBinding
import project.todoapp_kotlin.ui.view.acitivity.main.adapter.TodoListRecyclerViewAdapter
import project.todoapp_kotlin.ui.viewmodel.TodoListViewModel

class NewItemFragment : Fragment() {

    private lateinit var navController : NavController
    private lateinit var binding : FragmentNewItemBinding
    private val viewModel: TodoListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewItemBinding.inflate(inflater, container, false)

        return binding.root
    }

    inner class ClickHandler(){
        
    }

}