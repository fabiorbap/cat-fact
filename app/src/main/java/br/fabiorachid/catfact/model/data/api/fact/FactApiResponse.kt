package br.fabiorachid.catfact.model.data.api.fact

import com.google.gson.annotations.SerializedName

data class FactApiResponse(@SerializedName("fact") var fact: String? = "")