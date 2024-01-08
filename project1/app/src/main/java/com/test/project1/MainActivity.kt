package com.test.project1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.test.project1.homepage.CardsSec
import com.test.project1.homepage.CurrenciesSec
import com.test.project1.homepage.FinanceSec
import com.test.project1.homepage.WalletSec
import com.test.project1.ui.theme.Project1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project1Theme {
                // A surface container using the 'background' color from the theme

                SetBarColor(color = MaterialTheme.colorScheme.background)

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
private fun SetBarColor(color:Color){
    val systemUiController= rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(
            color=color
        )
    }
}

@Preview
@Composable
fun HomeScreen(){
    Scaffold(bottomBar={
            BottomNavigationBar()
        }
    ) {padding->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),

        ) {
            WalletSec()
            CardsSec()
            Spacer(modifier = Modifier.height(16.dp))
            FinanceSec()
            CurrenciesSec()
        }

    }
}