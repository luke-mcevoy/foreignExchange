package com.mcevoy.foreignexchange.model

data class ForexResponse(
    val base: String?,
    val rates: List<String>?
)