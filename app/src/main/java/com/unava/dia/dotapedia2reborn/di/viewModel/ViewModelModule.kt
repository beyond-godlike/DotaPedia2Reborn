package com.unava.dia.dotapedia2reborn.di.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.unava.dia.dotapedia2reborn.ui.heroConstructor.ctor.HeroConstructorViewModel
import com.unava.dia.dotapedia2reborn.ui.heroConstructor.picker.HeroPickerViewModel
import com.unava.dia.dotapedia2reborn.ui.dotabuff.match.MatchViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    // factory is singleton
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HeroConstructorViewModel::class)
    internal abstract fun bindHeroConstructorViewModel(viewModel: HeroConstructorViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HeroPickerViewModel::class)
    internal abstract fun bindHeroPickerViewModel(viewModel: HeroPickerViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MatchViewModel::class)
    internal abstract fun bindMatchViewModel(viewModel: MatchViewModel): ViewModel

    //Add more ViewModels here
}