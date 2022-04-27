package br.fabiorachid.catfact.model.data.remote.api

import com.google.gson.annotations.SerializedName

data class FactApiResponse(@SerializedName("fact") var fact: String? = "")