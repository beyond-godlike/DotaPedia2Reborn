package com.unava.dia.dotapedia2reborn

import android.app.Activity
import android.app.Application
import androidx.multidex.MultiDexApplication
import com.unava.dia.dotapedia2reborn.di.AppComponent
import com.unava.dia.dotapedia2reborn.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import io.realm.Realm
import io.realm.RealmConfiguration
import javax.inject.Inject

class DotaPediaApp : MultiDexApplication(), HasActivityInjector {
    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    var appComponent: AppComponent? = null
        private set

    override fun onCreate() {
        super.onCreate()
        this.initDagger()
        Realm.init(this)
        Realm.setDefaultConfiguration(RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build())
    }

    private fun initDagger() {
        this.appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
        this.appComponent!!
            .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity>? {
        return dispatchingActivityInjector
    }
}