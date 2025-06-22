package com.sellink.app.domain.models

import kotlinx.serialization.Serializable

@Serializable
class Good(
    val name: String,
    val price: Double,
    val category: String,
    val currency: String
)