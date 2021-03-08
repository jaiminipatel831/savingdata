package com.example.savingdata

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.content.Context


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()
        bt_Button.setOnClickListner{
            saveData()
        }

    }
    private fun saveData()
    {
        val insertedText : String = edittext.text.toString()
        textview.text = insertedText

        val sharedPreferences : SharedPreferences = getSharedPreferences(name"sharedPrefs", Content.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = sharedPreferences.edit()
        editor.apply{
            putString("STRING_KEY", insertedText)
            putBoolean("BOOLEAN_KEY", button.isChecked)
        }.apply()

        Toast.makeText(content: this, text: "Save", Toast.LENGTH_SHORT).show()
    }
    private fun loadData()
    {
        val sharedPreferences : SharedPreferences = getSharedPreferences(name"sharedPrefs", Content.MODE_PRIVATE)
        val savedString : String? = sharedPreferences.getString(key: "STRONG_KEY", defValue: null)
        val savedBoolean : Boolean = sharedPreferences.getBoolean( key: "BOOLEAN_KEY", defvalue: false)

        textview.text = savedString
        button.isChecked = savedBoolean
    }
}