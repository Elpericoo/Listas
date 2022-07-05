package com.elpericoo.listas

import android.icu.text.CaseMap
import java.time.LocalDateTime
import java.util.*

data class Item(
    val title: String,
    val description: String = "",
    var date: String = Date().toString(),
    var check: Boolean = false
)

