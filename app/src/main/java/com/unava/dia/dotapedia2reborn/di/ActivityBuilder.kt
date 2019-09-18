package com.unava.dia.dotapedia2reborn.di

import com.unava.dia.dotapedia2reborn.di.subModules.*
import com.unava.dia.dotapedia2reborn.ui.dotabuff.checker.MmrCheckerActivity
import com.unava.dia.dotapedia2reborn.ui.dotabuff.history.MatchesHistoryActivity
import com.unava.dia.dotapedia2reborn.ui.heroConstructor.ctor.HeroConstructorActivity
import com.unava.dia.dotapedia2reborn.ui.heroConstructor.picker.HeroPickerActivity
import com.unava.dia.dotapedia2reborn.ui.dotabuff.match.MatchActivity
import com.unava.dia.dotapedia2reborn.ui.pedia.DotapediaActivity
import com.unava.dia.dotapedia2reborn.ui.updates.UpdatesActivity
import com.unava.dia.dotapedia2reborn.ui.updates.update.OneUpdateActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [
        HeroConstructorActivityViewModule::class
    ])
    internal abstract fun bindHeroConstructorActivity(): HeroConstructorActivity

    @ContributesAndroidInjector(modules = [
        HeroPickerActivityViewModule::class
    ])
    internal abstract fun bindHeroPickerActivity(): HeroPickerActivity

    @ContributesAndroidInjector(modules = [
        MatchActivityViewModule::class
    ])
    internal abstract fun bindMatchActivity(): MatchActivity

    @ContributesAndroidInjector(modules = [
        DotapediaViewModule::class
    ])
    internal abstract fun bindDotapediaActivity(): DotapediaActivity

    @ContributesAndroidInjector(modules = [
        UpdatesViewModule::class
    ])
    internal abstract fun bindUpdatesActivity(): UpdatesActivity

    @ContributesAndroidInjector(modules = [
        OneUpdateViewModule::class
    ])
    internal abstract fun bindOneUpdateActivity(): OneUpdateActivity

    @ContributesAndroidInjector(modules = [
        MmrCheckerViewModule::class
    ])
    internal abstract fun bindMmrCheckerActivity(): MmrCheckerActivity

    @ContributesAndroidInjector(modules = [
        MatchesHistoryViewModule::class
    ])
    internal abstract fun bindMatchesHistoryActivity(): MatchesHistoryActivity
}