package com.elpericoo.listas

import android.content.ClipData
import android.content.Context
import android.util.Log
import org.json.JSONArray
import org.json.JSONObject
import java.io.File
import java.io.IOException
import java.util.*
import kotlin.math.log

class ListService(context: Context) {
    val context = context
    var list = mutableListOf<Item>()
    var json = JSONArray()

    init {
        try {
            json = JSONArray(
                context.assets.open("example.json").bufferedReader().use { it.readText() })
            for (i in 0 until json.length()) {
                var jsonObject = json.getJSONObject(i)
                var item: Item = Item(
                    jsonObject.optString("title"),
                    jsonObject.optString("description"),
                    jsonObject.optString("creationDate"),
                    jsonObject.getBoolean("check")
                )
                list.add(item)
            }

        } catch (ioException: IOException) {
            Log.d("Error", ioException.toString())
        }
    }
}




