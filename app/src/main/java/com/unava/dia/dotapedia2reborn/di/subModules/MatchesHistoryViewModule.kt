package com.unava.dia.dotapedia2reborn.di.subModules

import androidx.lifecycle.ViewModel
import com.unava.dia.dotapedia2reborn.ui.dotabuff.history.MatchesHistoryViewModel
import dagger.Binds
import dagger.Module

@Module
abstract class MatchesHistoryViewModule {
    @Binds
    abstract fun bindMatchesHistoryActivityViewModel(viewModel: MatchesHistoryViewModel): ViewModel
}