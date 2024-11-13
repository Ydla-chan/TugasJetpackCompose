package com.example.tugasandroid.Presentation

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.tooling.preview.Preview
import com.example.tugasandroid.ui.theme.TugasAndroidTheme

@Composable
fun tugasandroid() {
    TugasAndroidTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MainScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun tugasandroidPreview() {
    tugasandroid()
}
