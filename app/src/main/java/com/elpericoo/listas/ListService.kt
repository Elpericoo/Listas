package com.elpericoo.listas

import android.content.ClipData
import android.content.Context
import android.util.Log
import java.io.File
import kotlin.math.log

class ListService(context: Context) {
    val context = context
    val fileName = "lists.txt"
    val file = File(context.filesDir, fileName)
    var list = mutableListOf<String>()


    //Obtener datos del fichero local list.txt
    fun getListFromFile():MutableList<String>{
        if (!file.exists()) {
            file.createNewFile()
        }

        list = file.readLines() as MutableList<String>
        return list

    }

    fun addItemToList(item: String){
        list.add(item)
        file.printWriter().use {
            out -> list.forEach {
                out.println(it)
            }
        }
    }
}