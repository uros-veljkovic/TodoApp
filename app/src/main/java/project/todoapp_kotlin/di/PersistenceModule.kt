package project.todoapp_kotlin.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import project.todoapp_kotlin.repository.Repository
import project.todoapp_kotlin.repository.dao.TodoDao
import project.todoapp_kotlin.repository.db.TodoDatabase
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class PersistenceModule {

    @Singleton
    @Provides
    fun provideTodoDatabase(@ApplicationContext context: Context): TodoDatabase{
        return Room.databaseBuilder(
            context,
            TodoDatabase::class.java,
            TodoDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideTodoDao(todoDatabase: TodoDatabase): TodoDao{
        return todoDatabase.todoDao()
    }

    @Singleton
    @Provides
    fun provideRepository(todoDao: TodoDao): Repository{
        return Repository(todoDao)
    }


}