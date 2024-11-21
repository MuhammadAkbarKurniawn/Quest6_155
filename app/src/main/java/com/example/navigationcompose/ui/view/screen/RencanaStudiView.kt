package com.example.navigationcompose.ui.view.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.navigationcompose.model.Mahasiswa

@Composable
fun RencanaStudiView(
    mahasiswa: Mahasiswa,
    OnSubmitButtonClicked: (MutableList<String>) -> Unit,
    OnBackButtinClicked: () ->Unit,
){
    var chosenDropdown by remember { mutableStateOf("") }
    var checked by remember { mutableStateOf(false) }
    var pilihanKelas by remember { mutableStateOf("") }

    var listData: MutableList<String> = mutableListOf(chosenDropdown,pilihanKelas)
}