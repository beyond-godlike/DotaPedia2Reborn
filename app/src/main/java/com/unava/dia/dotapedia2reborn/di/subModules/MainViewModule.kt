package com.unava.dia.dotapedia2reborn.di.subModules

import androidx.lifecycle.ViewModel
import com.unava.dia.dotapedia2reborn.ui.main.MainViewModel
import dagger.Binds
import dagger.Module

@Module
abstract class MainViewModule {
    @Binds
    abstract fun bindMainViewModel(viewModel: MainViewModel) : ViewModel
}