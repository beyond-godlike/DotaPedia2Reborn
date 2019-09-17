package com.unava.dia.dotapedia2reborn.di.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.unava.dia.dotapedia2reborn.ui.dotabuff.checker.MmrCheckerViewModel
import com.unava.dia.dotapedia2reborn.ui.dotabuff.history.MatchesHistoryViewModel
import com.unava.dia.dotapedia2reborn.ui.heroConstructor.ctor.HeroConstructorViewModel
import com.unava.dia.dotapedia2reborn.ui.heroConstructor.picker.HeroPickerViewModel
import com.unava.dia.dotapedia2reborn.ui.dotabuff.match.MatchViewModel
import com.unava.dia.dotapedia2reborn.ui.pedia.DotapediaViewModel
import com.unava.dia.dotapedia2reborn.ui.updates.UpdatesViewModel
import com.unava.dia.dotapedia2reborn.ui.updates.update.OneUpdateViewModel
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

    @Binds
    @IntoMap
    @ViewModelKey(DotapediaViewModel::class)
    internal abstract fun bindDotapediaViewModel(viewModel: DotapediaViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(UpdatesViewModel::class)
    internal abstract fun bindUpdatesViewModel(viewModel: UpdatesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(OneUpdateViewModel::class)
    internal abstract fun bindOneUpdateViewModel(viewModel: OneUpdateViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MmrCheckerViewModel::class)
    internal abstract fun bindMmrCheckerViewModel(viewModel: MmrCheckerViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MatchesHistoryViewModel::class)
    internal abstract fun bindMatchesHistoryViewModel(viewModel: MatchesHistoryViewModel): ViewModel

    //Add more ViewModels here
}