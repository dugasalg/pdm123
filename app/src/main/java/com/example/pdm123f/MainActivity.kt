package com.example.pdm123f

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pdm123f.firstpartial.EvenOddView
import com.example.pdm123f.firstpartial.PadelScoreView
import com.example.pdm123f.navigation.NavBarItems
import com.example.pdm123f.navigation.NavRoutes
import com.example.pdm123f.ui.theme.PDM123fTheme

// Comentario de prueba
// Comentario de prueba
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PDM123fTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        topBar = { TopAppBar(title = { Text("ULSA CHIHUAHUA") }) },
        content = { it
            NavigationHost(navController = navController) },
        bottomBar = { BottomBar(navController = navController) }

    )

        }
@Composable
fun NavigationHost(navController: NavHostController) {

    NavHost(navController = navController, startDestination = NavRoutes.FirstPartial.route){
        composable(NavRoutes.FirstPartial.route){
            FirstPartialView(navController = navController)

        }
        composable(NavRoutes.SecondPartial.route){
            SecondPartialView()
        }
        composable(NavRoutes.ThirdPartial.route){
            ThirdPartialView()
        }
        composable(NavRoutes.PadelScore.route){
            PadelScoreView(navController = navController)
        }
        composable(NavRoutes.EvenOdd.route){
            EvenOddView(navController = navController)
        }
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    BottomNavigation {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        NavBarItems.NavBarItems.forEach { navItem ->
            BottomNavigationItem(
                icon = { Icon(imageVector = navItem.image, contentDescription = navItem.title.toString()) },
                label = { Text(text = stringResource(id = navItem.title)) },
                selected = currentRoute == navItem.route,
                onClick = {
                    navController.navigate(navItem.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PDM123fTheme {
        MainScreen()
    }
}



