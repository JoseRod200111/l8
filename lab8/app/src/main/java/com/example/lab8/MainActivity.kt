package com.example.lab8

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.lab8.ui.theme.MyRecipeAppTheme

class MainActivity : ComponentActivity() {

    // Instancia del ViewModel
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyRecipeAppTheme {
                // Una superficie que usa el tema de fondo
                Surface(color = MaterialTheme.colorScheme.background) {
                    // Pasamos la instancia del ViewModel al RecipeScreen
                    RecipeScreen(mainViewModel = mainViewModel)
                }
            }
        }
    }
}
