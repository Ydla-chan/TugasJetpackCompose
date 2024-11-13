package com.example.tugasandroid.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.tugasandroid.Presentation.BottomNavItem
import com.example.tugasandroid.Presentation.BottomNavigationBar
import com.example.tugasandroid.model.Task // Mengimpor dari package yang benar
import com.example.tugasandroid.data.sampleTasks // Mengimpor sampel data dari data package

@Composable
fun TaskCard(task: Task) {
    var showDialog by remember { mutableStateOf(false) }

    if (showDialog) {
        TaskDetailDialog(task = task, onDismiss = { showDialog = false })
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (task.overdue) Color(0xFFFFF0F0) else Color(0xFFF0FFF4)
        ),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = task.judulTugas,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (task.overdue) Color(0xFFD32F2F) else Color(0xFF388E3C)
                )
                if (task.overdue) {
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = "Overdue Icon",
                        tint = Color.Red,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = task.mataKuliah, fontSize = 14.sp, color = Color.Gray)
            Text(text = "Deadline: ${task.deadline} - ${task.time}", fontSize = 12.sp, color = Color.DarkGray)

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = { showDialog = true },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                modifier = Modifier.align(Alignment.End),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Lihat Detail", color = Color.White)
            }
        }
    }
}

@Composable
fun TaskDetailDialog(task: Task, onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            Button(onClick = onDismiss) {
                Text("Tutup")
            }
        },
        title = {
            Text(text = "Detail Tugas", fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        },
        text = {
            Column {
                Text(text = "Judul: ${task.judulTugas}", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Mata Kuliah: ${task.mataKuliah}")
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "Deadline: ${task.deadline} - ${task.time}")
                Spacer(modifier = Modifier.height(4.dp))
                if (task.overdue) {
                    Text(text = "Status: Overdue", color = Color.Red, fontWeight = FontWeight.Bold)
                } else {
                    Text(text = "Status: On Time", color = Color.Green, fontWeight = FontWeight.Bold)
                }
            }
        },
        shape = RoundedCornerShape(16.dp)
    )
}

@Composable
fun HorizontalTaskList(tasks: List<Task>) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(tasks) { task ->
            TaskCard(task)
        }
    }
}

@Composable
fun VerticalTaskList(tasks: List<Task>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(tasks) { task ->
            TaskCard(task)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskScreen(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Daftar Tugas", fontSize = 20.sp, fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        bottomBar = {
            BottomNavigationBar(
                selectedItem = BottomNavItem.Education,
                onItemSelected = { /* Handle navigation */ }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(Color(0xFFF3F3F3))
                .padding(paddingValues)
        ) {
            Text(
                text = "Tugas Mendatang",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF3E4A89),
                modifier = Modifier.padding(16.dp)
            )
            HorizontalTaskList(tasks = sampleTasks)

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Tugas yang Dikumpulkan Sekarang",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF3E4A89),
                modifier = Modifier.padding(16.dp)
            )
            VerticalTaskList(tasks = sampleTasks)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskScreenPreview() {
    TaskScreen()
}
