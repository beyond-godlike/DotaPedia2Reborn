package com.unava.dia.dotapedia2reborn.di

import com.unava.dia.dotapedia2reborn.di.subModules.HeroConstructorActivityViewModule
import com.unava.dia.dotapedia2reborn.di.subModules.HeroPickerActivityViewModule
import com.unava.dia.dotapedia2reborn.di.subModules.MatchActivityViewModule
import com.unava.dia.dotapedia2reborn.ui.heroConstructor.ctor.HeroConstructorActivity
import com.unava.dia.dotapedia2reborn.ui.heroConstructor.picker.HeroPickerActivity
import com.unava.dia.dotapedia2reborn.ui.dotabuff.match.MatchActivity
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
}