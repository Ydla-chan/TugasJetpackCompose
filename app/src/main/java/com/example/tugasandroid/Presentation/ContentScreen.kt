package com.example.tugasandroid.Presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding

@Composable
fun ContentScreen(selectedItem: BottomNavItem, modifier: Modifier = Modifier) {
    when (selectedItem) {
        BottomNavItem.Home -> Text("Home Screen", modifier = modifier.padding(16.dp))
        BottomNavItem.Orders -> Text("Orders Screen", modifier = modifier.padding(16.dp))
        BottomNavItem.Education -> Text("Education Screen", modifier = modifier.padding(16.dp))
        BottomNavItem.Profile -> Text("Profile Screen", modifier = modifier.padding(16.dp))
    }
}
