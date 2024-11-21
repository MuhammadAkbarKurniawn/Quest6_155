package com.example.navigationcompose.ui.view.screen

import androidx.compose.runtime.Composable
import com.example.navigationcompose.model.Mahasiswa
import com.example.navigationcompose.model.RencanaStudi

@Composable
fun HasilKrsView(
    mahasiswa: Mahasiswa,
    rencanaStudi: RencanaStudi,
    onBackToFormClicked: () -> Unit,
    onFinishClicked: () -> Unit
){}

