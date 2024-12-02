package com.ork.photogallery.navigation.bottomnavigationbar

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ork.photogallery.mainscreen.MainScreen
import com.ork.photogallery.model.BottomNavItem
import com.ork.photogallery.utils.AppRoute


val bottomNavItems = listOf(
    BottomNavItem("Home", AppRoute.Main.route, Icons.Default.Home),
    BottomNavItem("Search", AppRoute.Search.route, Icons.Default.Search),
    BottomNavItem("Profile", AppRoute.Settings.route, Icons.Default.Person)
)
@Composable
fun BottomNavigationBar(navController: NavHostController) {
    BottomNavigation(
        backgroundColor = Color.Gray,
        contentColor = Color.White,
        modifier = Modifier
            .shadow(8.dp) // Opsiyonel gölge efekti
    ) {
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

        bottomNavItems.forEach { item ->
            BottomNavigationItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = { Icon(imageVector = item.icon, contentDescription = item.name) },
                label = { Text(text = item.name) },
                selectedContentColor = Color.Gray,
                unselectedContentColor = Color.Gray
            )
        }
    }
}


