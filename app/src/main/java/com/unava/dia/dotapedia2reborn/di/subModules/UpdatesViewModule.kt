package com.unava.dia.dotapedia2reborn.di.subModules

import androidx.lifecycle.ViewModel
import com.unava.dia.dotapedia2reborn.ui.updates.UpdatesViewModel
import dagger.Binds
import dagger.Module

@Module
abstract class UpdatesViewModule {
    @Binds
    abstract fun bindMatchActivityViewModel(viewModel: UpdatesViewModel): ViewModel
}