package com.pico.crypto.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pico.crypto.presentation.coin_detail.CoinDetailScreen
import com.pico.crypto.presentation.coin_list.CoinListScreen
import com.pico.crypto.presentation.ui.theme.CryptoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            CryptoTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(title = {Text(text = "Crypto Coins")})
                    }
                ) {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it)
                            .padding(16.dp),
                        color = MaterialTheme.colorScheme.background,
                    ) {
                        NavHost(navController = navController, startDestination = Screens.CoinListScreen.route){
                            composable(Screens.CoinListScreen.route){
                                CoinListScreen(navController = navController)
                            }
                            composable(Screens.CoinDetailScreen.route + "/{coinId}"){
                                CoinDetailScreen()
                            }
                        }
                    }
                }

            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CryptoTheme {
        Greeting("Android")
    }
}