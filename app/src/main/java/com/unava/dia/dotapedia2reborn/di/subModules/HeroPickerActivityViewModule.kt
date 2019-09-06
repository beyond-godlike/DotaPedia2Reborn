package com.unava.dia.dotapedia2reborn.di.subModules

import androidx.lifecycle.ViewModel
import com.unava.dia.dotapedia2reborn.ui.heroConstructor.picker.HeroPickerViewModel
import dagger.Binds
import dagger.Module

@Module
abstract class HeroPickerActivityViewModule {
    @Binds
    abstract fun bindHeroPickerActivityViewModel(viewModel: HeroPickerViewModel): ViewModel
}