package com.unava.dia.dotapedia2reborn.di.subModules

import androidx.lifecycle.ViewModel
import com.unava.dia.dotapedia2reborn.ui.pedia.DotapediaViewModel
import dagger.Binds
import dagger.Module

@Module
abstract class DotapediaViewModule {
    @Binds
    abstract fun bindDotapediaActivityViewModel(viewModel: DotapediaViewModel): ViewModel
}