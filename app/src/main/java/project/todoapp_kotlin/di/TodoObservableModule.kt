package project.todoapp_kotlin.di

import android.database.Observable
import androidx.databinding.ObservableField
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class TodoInChargeObservable

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class TodoTextObservable

@Module
@InstallIn(ActivityComponent::class)
class TodoObservableModule {

    @TodoInChargeObservable
    @Provides
    fun provideInChargeStringObservable() : ObservableField<String>{
        return ObservableField<String>()
    }

    @TodoTextObservable
    @Provides
    fun provideTextStringObservable() : ObservableField<String>{
        return ObservableField<String>()
    }

}