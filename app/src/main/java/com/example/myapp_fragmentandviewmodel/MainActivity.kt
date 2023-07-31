package com.example.myapp_fragmentandviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapp_fragmentandviewmodel.ui.main.MainFragment
import com.example.myapp_fragmentandviewmodel.ui.main.github.GitHubFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, GitHubFragment.newInstance())
                .commitNow()
        }
    }
}