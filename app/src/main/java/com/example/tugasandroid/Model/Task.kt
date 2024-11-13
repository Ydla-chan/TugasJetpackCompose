package com.example.tugasandroid.model

data class Task(
    val judulTugas: String,
    val mataKuliah: String,
    val deadline: String,  // Tanggal
    val time: String,      // Jam
    val overdue: Boolean   // Apakah sudah terlambat
)

val sampleTasks = listOf(
    Task("PENGUMPULAN P5 TRPL 3B MALAM (BN)", "Administrasi Sistem Komputer/RPL313", "28 October 2024", "23:59", overdue = true),
    Task("ATS Praktikum Reguler A", "Administrasi Sistem Komputer/RPL313", "29 October 2024", "20:55", overdue = true),
    Task("Pengumpulan ATS Praktikum Kelas B Malam (BN)", "Administrasi Sistem Komputer/RPL313", "30 October 2024", "23:59", overdue = true),
    Task("Pengumpulan tugas kelas 3A malam dan 3B malam", "Pengujian Perangkat Lunak/RPL316", "5 November 2024", "23:00", overdue = true),
    Task("Desain Handoff", "Interaksi Manusia Komputer/RPL315", "8 November 2024", "00:00", overdue = true)
)
