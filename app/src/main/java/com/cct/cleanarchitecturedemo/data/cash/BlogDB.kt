package com.cct.cleanarchitecturedemo.data.cash

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TBL_Blog")
data class BlogDB(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo("id")
    private val id:Int,
    @ColumnInfo("title")
    val title: String,
    @ColumnInfo("body")
    val body: String,
    @ColumnInfo("v")
    val image: String,
    @ColumnInfo("category")
    val category: String
) {
}