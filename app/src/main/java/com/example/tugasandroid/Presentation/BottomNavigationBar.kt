package com.example.tugasandroid.Presentation

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.TaskAlt
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.ui.unit.dp

@Composable
fun BottomNavigationBar(
    onItemSelected: (BottomNavItem) -> Unit,
    selectedItem: BottomNavItem
) {
    NavigationBar(
        tonalElevation = 10.dp,
        containerColor = MaterialTheme.colorScheme.surface
    ) {
        BottomNavItem.values().forEach { item ->
            NavigationBarItem(
                icon = { Icon(imageVector = item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = selectedItem == item,
                onClick = { onItemSelected(item) }
            )
        }
    }
}

enum class BottomNavItem(val icon: ImageVector, val label: String) {
    Home(Icons.Filled.Home, "Beranda"),
    Orders(Icons.Filled.School, "Mata Kuliah"),
    Education(Icons.Filled.TaskAlt, "Tugas"),
    Profile(Icons.Filled.AccountCircle, "Profile")
}
