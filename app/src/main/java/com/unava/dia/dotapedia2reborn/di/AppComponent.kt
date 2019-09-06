package com.unava.dia.dotapedia2reborn.di

import android.app.Application
import com.unava.dia.dotapedia2reborn.DotaPediaApp
import com.unava.dia.dotapedia2reborn.di.network.NetworkModule
import com.unava.dia.dotapedia2reborn.di.viewModel.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityBuilder::class,
        ViewModelModule::class,
        NetworkModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: DotaPediaApp)
}