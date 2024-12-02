package com.ork.photogallery.navigation.approute

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ork.photogallery.detailsscreen.DetailsPageScreen
import com.ork.photogallery.mainscreen.MainScreen
import com.ork.photogallery.model.UnSplashPhotoModel
import com.ork.photogallery.navigation.CustomToolbar
import com.ork.photogallery.navigation.bottomnavigationbar.BottomNavigationBar
import com.ork.photogallery.utils.AppRoute

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            CustomToolbar(title = "Ana Sayfa")
        },
        bottomBar = {
            val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
            if (currentRoute != AppRoute.Details.route) {
                BottomNavigationBar(navController)
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = AppRoute.Main.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(AppRoute.Main.route) { MainScreen(navController) }
            composable(AppRoute.Search.route) { /* SearchScreen() */ }
            composable(AppRoute.Settings.route) { /* ProfileScreen() */ }
            composable(AppRoute.Details.route) {
                DetailsPageScreen()}
        }
    }
}
