package com.example.navigationcompose.ui.view.screen

import androidx.compose.runtime.Composable
import com.example.navigationcompose.model.Mahasiswa

@Composable
fun RencanaStudiView(
    mahasiswa: Mahasiswa,
    OnSubmitButtonClicked: (MutableList<String>) -> Unit,
    OnBackButtinClicked: () ->Unit,
){}