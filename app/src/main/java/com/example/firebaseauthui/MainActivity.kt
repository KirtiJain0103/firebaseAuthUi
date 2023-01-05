package com.example.firebaseauthui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button: Button = findViewById(R.id.btn)

        val signInLauncher = registerForActivityResult(
            FirebaseAuthUIActivityResultContract()
        ) {

        }

        val signInIntent = AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(
                listOf(
                    AuthUI.IdpConfig.GoogleBuilder().build()
                )
            )
            .build()

        button.setOnClickListener {


            signInLauncher.launch(signInIntent)
        }

    }
}