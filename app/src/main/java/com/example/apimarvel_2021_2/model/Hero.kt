package com.example.apimarvel_2021_2.model

import com.google.gson.annotations.SerializedName

class Hero (
    @SerializedName(value = "id")
    var  id: Int,
    @SerializedName(value = "name")
    var nome: String,
    @SerializedName(value = "description")
    var descricao: String,
    @SerializedName(value = "modified")
    var dataDeModicacao: String,
    @SerializedName(value = "thumbnail")
    var imagemDoHeroi: Thumbnail
        )