package com.mcevoy.foreignexchange.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mcevoy.foreignexchange.R
import com.mcevoy.foreignexchange.model.ForexAPIService

class MainActivity : AppCompatActivity() {

    private val forexService = ForexAPIService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


}