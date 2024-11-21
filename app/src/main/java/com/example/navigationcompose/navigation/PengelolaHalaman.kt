package com.example.navigationcompose.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationcompose.model.RencanaStudiViewModel
import com.example.navigationcompose.ui.view.screen.HasilKrsView
import com.example.navigationcompose.ui.view.screen.MahasiswaFormView
import com.example.navigationcompose.ui.view.screen.RencanaStudiView
import com.example.navigationcompose.ui.view.screen.SplashView
import com.example.navigationcompose.ui.view.viewmodel.MahasiswaViewModel

enum class Halaman {
    Splash,
    Mahasiswa,
    Matakuliah,
    Tampil
}

@Composable
fun MahasiswaApp(
    modifier: Modifier = Modifier,
    mahasiswaViewModel: MahasiswaViewModel = viewModel(),
    krsViewModel: RencanaStudiViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
){
    val mahasiswaUiState = mahasiswaViewModel.mahasiswaUiState.collectAsState().value
    val krsState = krsViewModel.krsStateUi.collectAsState().value


    NavHost(
        navController = navController,
        startDestination = Halaman.Splash.name,
        modifier = modifier.padding()
    ) {
        composable(route = Halaman.Splash.name){
            SplashView (onMulaiButton = {
                navController.navigate(Halaman.Mahasiswa.name)
            })
        }
        composable(route = Halaman.Mahasiswa.name){
            MahasiswaFormView (
                onSubmitButton = {mahasiswaViewModel.saveDataMahasiswa(it)
                                 navController.navigate(Halaman.Matakuliah.name)},
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }
        composable(route = Halaman.Matakuliah.name){
            RencanaStudiView(
                mahasiswa = mahasiswaUiState,
                OnSubmitButtonClicked = { data ->
                    krsViewModel.saveDataKRS(data)
                    navController.navigate(Halaman.Tampil.name)
                },
                OnBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }
        composable(route = Halaman.Tampil.name){
            HasilKrsView(
                mahasiswa = mahasiswaUiState,
                rencanaStudi = krsState,
                onBackToFormClicked = { navController.navigate(Halaman.Matakuliah.name) },
                onFinishClicked = {
                    navController.navigate(Halaman.Splash.name) {
                        popUpTo(0)
                    }
                }
            )
        }
    }
}