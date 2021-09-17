package com.example.sharedpreferencesdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    private val backButton: Button by lazy {
        findViewById(R.id.backButton)
    }

    private val nameTextView: TextView by lazy {
        findViewById(R.id.nameTextView)
    }

    lateinit var sharedPreference: SharedPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        sharedPreference = SharedPreference(this)
        getToken()
        setButton()
    }

    private  fun setButton() {
        backButton.text = "Seconde Page"
        backButton.setOnClickListener {
            setToken()
           finish()
        }
    }

    private fun getToken() {
//        nameTextView.text = AuthToken.totken
        nameTextView.text = sharedPreference.getValue("token")
    }

    private fun setToken() {
//        AuthToken.totken = "Text......."
        sharedPreference.setValue("token", "456")
    }

    override fun onBackPressed() {
        setToken()
        super.onBackPressed()

    }

}