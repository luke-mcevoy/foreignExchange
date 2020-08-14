package com.mcevoy.foreignexchange.model

import java.sql.Timestamp

data class ForexResponse(
    val success: Boolean?,
    val timestamp: Timestamp?,
    val base: String?,
    val rates: List<Float>?
)