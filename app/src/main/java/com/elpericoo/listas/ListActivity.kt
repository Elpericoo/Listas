package com.elpericoo.listas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.jocnunez.listas.R
import com.elpericoo.listas.ListService
import java.util.*

class ListActivity : AppCompatActivity() {
    var list: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        Log.d("Debug","List Activity Open")

        val listService = ListService(this)
        list = listService.getListFromFile()
        list.forEach {
            addItemToLayout(it)
        }

  /*      val newItem = findViewById<Button>(R.id.newButton)
        newItem.setOnClickListener {
            addNewItem(listService)
        }*/
    }

    private fun addNewItem(service: ListService) {
        val randomText = Date().toString()
        service.addItemToList(randomText)
        addItemToLayout(randomText)
    }

    private fun addItemToLayout(text: String) {
        val textView = TextView(this)
        textView.text = text

        val listLayout = findViewById<LinearLayout>(R.id.listLayout)
        listLayout.addView(textView)
    }
}