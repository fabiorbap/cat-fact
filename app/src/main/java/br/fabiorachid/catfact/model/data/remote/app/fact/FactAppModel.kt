package br.fabiorachid.catfact.model.data.remote.app.fact

import com.google.gson.annotations.SerializedName

data class FactAppModel(@SerializedName("fact") var fact: String? = "")