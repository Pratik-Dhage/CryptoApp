package com.example.cryptoapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cryptoapp.presentation.coin_detail.components.CoinDetailScreen
import com.example.cryptoapp.presentation.coin_list.components.CoinListScreen
import com.example.cryptoapp.presentation.ui.theme.CryptoAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint  // Dagger Allows to inject Dependency from here that we need for ViewModel
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = Color.Black
                ){
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                    startDestination = Screen.CoinListScreen.route
                        ){

                        composable(route = Screen.CoinListScreen.route){
                         CoinListScreen(navController)
                        }

                        composable(route = Screen.CoinDetailScreen.route + "/{coinId}"){
                           CoinDetailScreen()
                        }
                    }
                }
            }
        }
    }
}



