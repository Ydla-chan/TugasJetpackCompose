package com.example.tugasandroid.Model

data class MataKuliah(
    val id: Int,
    val title: String,
    val dosenPengampu: String
) {
    data class GambarMataKuliah(
        val id: Int,
        val title: String,
        val dosenPengampu: String
    )
}