package com.example.navigationcompose.ui.view.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navigationcompose.R
import com.example.navigationcompose.model.Mahasiswa
import com.example.navigationcompose.model.RencanaStudi

@Composable
fun HasilKrsView(
    mahasiswa: Mahasiswa,
    rencanaStudi: RencanaStudi,
    onBackToFormClicked: () -> Unit,
    onFinishClicked: () -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.primary))
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Ringkasan Data",
            fontSize = 24.sp,
            color = Color.White,
            modifier = Modifier.padding(8.dp)
        )

        Spacer(modifier = Modifier.size(12.dp))

        Column (
            modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(16.dp)
        ){
            Text(text = "Informasi Mahasiswa", fontSize = 18.sp, color = Color.Black)
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = "NIM: ${mahasiswa.nim}", fontSize = 14.sp, color = Color.Gray)
            Text(text = "Nama: ${mahasiswa.nama}", fontSize = 14.sp, color = Color.Gray)
            Text(text = "Email: ${mahasiswa.email}", fontSize = 14.sp, color = Color.Gray)
        }

        Spacer(modifier = Modifier.size(12.dp))

        Column (
            modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(16.dp))
        {
            Text(text = "Rencana Studi", fontSize = 18.sp, color = Color.Black)
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = "Mata Kuliah: ${rencanaStudi.namaMK}", fontSize = 14.sp, color = Color.Gray)
            Text(text = "Kelas: ${rencanaStudi.kelas}", fontSize = 14.sp, color = Color.Gray)
        }

        Spacer(modifier = Modifier.size(12.dp))

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ){
            Button(onClick = onBackToFormClicked) {
                Text(text = "Kembali")
            }
            Button(onClick = onFinishClicked) {
                Text(text = "Selesai")
            }
        }
}}

