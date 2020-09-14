package project.todoapp_kotlin.model

import androidx.databinding.ObservableField
import project.todoapp_kotlin.di.TodoInChargeObservable
import project.todoapp_kotlin.di.TodoTextObservable
import javax.inject.Inject

data class TodoObservable
@Inject
constructor(

    @TodoTextObservable
    val text: ObservableField<String>,

    @TodoInChargeObservable
    val inCharge: ObservableField<String>

) {


}
