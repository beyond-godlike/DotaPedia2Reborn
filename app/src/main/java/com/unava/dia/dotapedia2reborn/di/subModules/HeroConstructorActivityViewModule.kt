package com.unava.dia.dotapedia2reborn.di.subModules

import androidx.lifecycle.ViewModel
import com.unava.dia.dotapedia2reborn.ui.heroConstructor.ctor.HeroConstructorViewModel
import dagger.Binds
import dagger.Module

@Module
abstract class HeroConstructorActivityViewModule {
    @Binds
    abstract fun bindHeroConstructorActivityViewModel(viewModel: HeroConstructorViewModel): ViewModel
}