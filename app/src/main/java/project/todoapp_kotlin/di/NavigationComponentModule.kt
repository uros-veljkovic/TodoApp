package project.todoapp_kotlin.di

import android.app.Activity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent
import project.fragments.todoapp_kotlin.R
import project.todoapp_kotlin.ui.view.acitivity.main.MainActivity

@InstallIn(ActivityComponent::class)
@Module
class NavigationComponentModule {

    @Provides
    fun provideNavigationComponent(activity: Activity) : NavController {
        return activity.findNavController(R.id.nav_host_fragment_container)
    }

}