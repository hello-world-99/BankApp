package com.test.project1.data

import androidx.compose.ui.graphics.vector.ImageVector

data class Currency(
    val name: String,
    val buy: Double,
    val sell: Double,
    val icon: ImageVector
)
