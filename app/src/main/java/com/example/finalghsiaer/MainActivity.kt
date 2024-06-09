@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.finalghsiaer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.finalghsiaer.model.ClubsRepository
import com.example.finalghsiaer.ui.theme.FinalGhsiaerTheme
import com.example.finalghsiaer.ui.theme.ClubList
import com.example.finalghsiaer.model.ClubsRepository.clubs

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinalGhsiaerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ClubApp()
                }
            }
        }
    }
}

@Composable
fun ClubApp(){
    Scaffold ( modifier = Modifier.fillMaxSize(),
        topBar = { TopBarClub()}){
        val heroes = ClubsRepository.clubs
        ClubList(clubs = clubs, contentPadding = it)
    }

}

@Composable
fun TopBarClub(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(title = { Text(
        text = "Club App Nour Ghsaier",
        style = MaterialTheme.typography.displayMedium,
    ) },
        modifier=modifier)
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FinalGhsiaerTheme {
        ClubApp()
    }
}