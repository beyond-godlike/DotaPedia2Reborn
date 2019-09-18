package com.unava.dia.dotapedia2reborn.di.subModules

import androidx.lifecycle.ViewModel
import com.unava.dia.dotapedia2reborn.ui.dotabuff.checker.MmrCheckerViewModel
import dagger.Binds
import dagger.Module

@Module
abstract class MmrCheckerViewModule {
    @Binds
    abstract fun bindDotapediaActivityViewModel(viewModel: MmrCheckerViewModel): ViewModel
}