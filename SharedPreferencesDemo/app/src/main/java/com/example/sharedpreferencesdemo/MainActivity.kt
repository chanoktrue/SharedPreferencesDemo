package com.example.sharedpreferencesdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val tokenTextView: TextView by lazy {
        findViewById(R.id.tokenTextView)
    }

    private val nextButton: Button by lazy {
        findViewById(R.id.nextButton)
    }

    lateinit var sharedPreference: SharedPreference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedPreference = SharedPreference(this)
        getToken()
        setButton()

    }

    private  fun setButton() {
        nextButton.text = "First page"
        nextButton.setOnClickListener {
            saveToken()
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getToken() {
//        tokenTextView.text = AuthToken.totken
        tokenTextView.text = sharedPreference.getValue("token")

    }

    private  fun saveToken() {
//        AuthToken.totken = "Token 1234"
        sharedPreference.setValue("token", "123")
    }

}