package com.example.test_kotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException
import java.io.InputStream

class MainActivity : AppCompatActivity() {

    private val contactList = ArrayList<ContactModel>()
    private lateinit var contactAdapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerviewContact)
        contactAdapter = ContactAdapter(contactList)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = contactAdapter
        getDataContact(this)
    }

    private fun LoadContactData(){
        val jsonFileString = getJsonDataFromAsset(applicationContext, "data.json")
        if (jsonFileString != null) {
            Log.i("data", jsonFileString)
        }
        val gson = Gson()
        val listPersonType = object : TypeToken<List<ContactModel>>() {}.type
        var persons: List<ContactModel> = gson.fromJson(jsonFileString, listPersonType)
        persons.forEachIndexed { idx, person -> Log.i("data", "> Item $idx:\n$person") }
    }

    fun getDataContact(context: Context): List<ContactModel> {

        lateinit var jsonString: String
        try {
            val inputStream: InputStream = assets.open("data.json")
            jsonString = inputStream.bufferedReader().use { it.readText() }

            Log.i("json data", jsonString)
        } catch (ioException: IOException) {

        }

        val listCountryType = object : TypeToken<List<ContactModel>>() {}.type
        return Gson().fromJson(jsonString, listCountryType)
    }
}