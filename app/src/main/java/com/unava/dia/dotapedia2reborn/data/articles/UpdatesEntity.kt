package com.unava.dia.dotapedia2reborn.data.articles

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "updates")
data class UpdatesEntity(var title: String? = null,
                         var description: String? = null,
                         var date: String? = null,
                         var urlToFullArticle: String? = null) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    @Ignore
    constructor() : this("title", "description", "date", "urlToFullArticle")
}