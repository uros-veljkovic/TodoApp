package project.todoapp_kotlin.di

import androidx.lifecycle.MutableLiveData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import project.todoapp_kotlin.repository.entity.TodoEntity

@InstallIn(ActivityRetainedComponent::class)
@Module
class ViewModelModule {

    @Provides
    fun provideTodoList() : MutableLiveData<List<TodoEntity>> {
        return MutableLiveData<List<TodoEntity>>()
    }
}