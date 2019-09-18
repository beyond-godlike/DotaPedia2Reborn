package com.unava.dia.dotapedia2reborn.di.subModules

import androidx.lifecycle.ViewModel
import com.unava.dia.dotapedia2reborn.ui.dotabuff.match.MatchViewModel
import dagger.Binds
import dagger.Module

@Module
abstract class MatchActivityViewModule {
    @Binds
    abstract fun bindMatchActivityViewModel(viewModel: MatchViewModel): ViewModel
}