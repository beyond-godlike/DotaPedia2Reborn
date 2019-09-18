package com.unava.dia.dotapedia2reborn.data

import android.content.Context
import io.realm.Realm
import io.realm.RealmResults
import java.io.InputStream

// TODO migrate from realm to room
class DotaHeroDao(private val context: Context) {
    private val realm = Realm.getDefaultInstance()
    fun initRepos() {
        if(realm.isEmpty){
            try {
                val inputStream: InputStream = context.assets.open("heroes.json")
                realm.beginTransaction()
                realm.createAllFromJson(DotaHero::class.java, inputStream)
                realm.commitTransaction()
            }
            catch (e: Throwable) {
                if(realm.isInTransaction) {
                    realm.cancelTransaction()
                }
                throw RuntimeException(e)
            }
        }
    }

    fun loadRepos() : RealmResults<DotaHero> {
        return realm.where(DotaHero::class.java)
            .findAll()
    }
}