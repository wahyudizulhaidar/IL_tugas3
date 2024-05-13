package com.example.tugas3

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tugas3.navigation.NavigationItem
import com.example.tugas3.navigation.Screen

@Composable
private fun BottomBar(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier
    ) {
        val navBarStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBarStackEntry?.destination?.route

        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(id = R.string.menu_home),
                icon = Icons.Default.Home,
                screen = Screen.Home
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_gallery),
                icon = Icons.Default.CheckCircle,
                screen = Screen.Gallery
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_about),
                icon = Icons.Default.AccountCircle,
                screen = Screen.About
            )
        )
        navigationItems.map { Item ->
            NavigationBarItem(
                selected = currentRoute == Item.screen.route,
                onClick = {
                    navController.navigate(Item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                icon = { Icon(imageVector = Item.icon, contentDescription = Item.title) },
                label = { Text(text = Item.title) }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Jetpek(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            val currentRoute =
                navController.currentBackStackEntryAsState().value?.destination?.route

            val appBarTitle = when (currentRoute) {
                Screen.Home.route -> stringResource(id = R.string.menu_home)
                Screen.Gallery.route -> stringResource(id = R.string.menu_gallery)
                Screen.About.route -> stringResource(id = R.string.menu_about)
                else -> "Aplikasi"
            }

            TopAppBar(
                title = { Text(text = appBarTitle) },
                actions = {
                    IconButton(onClick = { (context) }) {
                        Icon(
                            imageVector = Icons.Default.Share, contentDescription = stringResource(
                                id = R.string.menu_share
                            )
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomBar(navController)
        },
        modifier = modifier
    ) { contentPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = modifier.padding(contentPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(navController)
            }
            composable(Screen.Gallery.route) {
                GalleryScreen()
            }
            composable(Screen.About.route) {
                AboutScreen()
            }
            composable(
                Screen.Detail.route + "/{mentorId}",
                arguments = listOf(navArgument("mentorId") { type = NavType.IntType })
            ) { navBackStackEntry ->
                DetailScreen(
                    navController = navController,
                    oranggId = navBackStackEntry.arguments?.getInt("mentorId")
                )
            }
        }
    }
}