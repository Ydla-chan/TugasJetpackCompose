package com.example.tugasandroid.Presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tugasandroid.presentation.TaskScreen

@Composable
fun MainScreen() {
    var selectedItem by remember { mutableStateOf(BottomNavItem.Home) }

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                onItemSelected = { selectedItem = it },
                selectedItem = selectedItem
            )
        }
    ) { paddingValues ->
        when (selectedItem) {
            BottomNavItem.Home -> HomeScreen(modifier = Modifier.padding(paddingValues))
            BottomNavItem.Orders -> MataKuliahScreen(modifier = Modifier.padding(paddingValues))
            BottomNavItem.Education -> TaskScreen(modifier = Modifier.padding(paddingValues))
            BottomNavItem.Profile -> ProfileScreen(modifier = Modifier.padding(paddingValues))
        }
    }
}




@Preview
@Composable
fun MainScreenPreview(){
    MainScreen()

}