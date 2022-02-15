package com.cct.cleanarchitecturedemo.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import javax.inject.Inject

@Entity(tableName = "tbl_blog")
data class Blog (
    @SerializedName("pk")
    @PrimaryKey(autoGenerate = false)
    var pk: Int,
    @SerializedName("body")
    var body: String,
    @SerializedName("category")
    var category: String,
    @SerializedName("image")
    var image: String,
    @SerializedName("title")
    var title: String
)