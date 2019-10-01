package com.unava.dia.dotapedia2reborn.data.icons

import io.realm.RealmObject
import io.realm.annotations.RealmClass

@RealmClass
open class HeroIcons(
    open var localized_name: String? = null,
    open var url_full_portrait: String? = null,
    open var name: String? = null,
    open var url_small_portrait: String? = null,
    open var url_large_portrait: String? = null,
    open var url_vertical_portrait: String? = null,
    open var id: Int? = null
) : RealmObject() {}