package com.example.navigationcompose.ui.view.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navigationcompose.R


@Composable
fun MahasiswaFormView(
    onSubmitButton: (MutableList<String>) -> Unit,
    onBackButtonClicked: () -> Unit,
){

    var nama by remember { mutableStateOf("") }
    var nim by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    var listData: MutableList<String> = mutableListOf(nim,nama,email)

    Column (modifier = Modifier
        .fillMaxSize()
        .background(
            color = colorResource(id = R.color.primary)
        )
    ){
        Row (modifier = Modifier.padding(25.dp),
            verticalAlignment = Alignment.CenterVertically,
        ){
            Image(
                painter = painterResource(id = R.drawable.pngwingimg),
                contentDescription = "",
                modifier = Modifier .size(90.dp),
            )

            Spacer(modifier = Modifier.padding(start = 30.dp))

            Column {
                Text(
                    text = "Universitas Muhammadiyah Yogyakarta",
                    color = Color.Red,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Unggul dan Islami",
                    color = Color.Red,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Light
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(
                        topEnd = 18.dp,
                        topStart = 18.dp
                    )
                )
        ){
            Column (
                modifier = Modifier
                    .fillMaxWidth().padding(17.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text = "Masukkan Data Disini!",
                    fontWeight = FontWeight.Bold,
                    fontSize = 19.sp
                )
                Text(
                    text = "Isi Sesuai Data Yang Kamu Daftarkan",
                    fontWeight = FontWeight.Light,
                    fontSize = 17.sp
                )

                Spacer(modifier = Modifier.padding(4.dp))

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(50.dp),
                    value = nim,
                    onValueChange = {nim =it},
                    label = { Text(text = "Nomor Induk Mahasiswa")},
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Info,
                            contentDescription = ""
                        )
                    }
                )

                Spacer(modifier = Modifier.padding(4.dp))

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(50.dp),
                    value = nama,
                    onValueChange = {nama =it},
                    label = { Text(text = "Masukkan Nama Anda")},
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription = ""
                        )
                    }
                )

                Spacer(modifier = Modifier.padding(4.dp))

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(50.dp),
                    value = email,
                    onValueChange = {email =it},
                    label = { Text(text = "Masukkan Email Anda")},
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Email,
                            contentDescription = ""
                        )
                    }
                )

                Spacer(modifier = Modifier.padding(8.dp))

                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ){
                    Button(onClick = {onBackButtonClicked()}){
                        Text(text = "Kembali")
                    }

                    Button(onClick = {onSubmitButton(listData)}) {
                        Text(text = "Simpan")
                    }
                }
            }

        }
    }

}