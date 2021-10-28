package com.example.apimarvel_2021_2.model

import com.google.gson.annotations.SerializedName

class Thumbnail (
    @SerializedName(value = "path")
    var path: String,
    @SerializedName(value = "extension")
    var extension: String
    ){
    fun getURL():String{
        var url = "$path.$extension"
        if(url.contains("http"))
            url = url.replace("http","https")
        return url
    }
}