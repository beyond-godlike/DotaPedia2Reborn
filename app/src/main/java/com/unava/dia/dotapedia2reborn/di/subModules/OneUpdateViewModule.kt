package com.unava.dia.dotapedia2reborn.di.subModules

import androidx.lifecycle.ViewModel
import com.unava.dia.dotapedia2reborn.ui.updates.update.OneUpdateViewModel
import dagger.Binds
import dagger.Module

@Module
abstract class OneUpdateViewModule {
    @Binds
    abstract fun bindHeroConstructorActivityViewModel(viewModel: OneUpdateViewModel): ViewModel
}