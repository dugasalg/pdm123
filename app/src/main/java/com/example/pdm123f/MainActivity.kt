package com.example.pdm123f

import ApplesViewModel
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
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pdm123f.firstpartial.*
import com.example.pdm123f.navigation.NavBarItems
import com.example.pdm123f.navigation.NavRoutes
import com.example.pdm123f.secondpartial.Listas.ListasView
import com.example.pdm123f.secondpartial.Qr.QrView
import com.example.pdm123f.secondpartial.onboarding.OnboardingView
import com.example.pdm123f.ui.theme.PDM123fTheme
import com.google.accompanist.pager.ExperimentalPagerApi

// Comentario de prueba
// Comentario de prueba
@androidx.camera.core.ExperimentalGetImage

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPagerApi::class)
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
@androidx.camera.core.ExperimentalGetImage
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
@androidx.camera.core.ExperimentalGetImage
fun NavigationHost(navController: NavHostController) {

    NavHost(navController = navController, startDestination = NavRoutes.FirstPartial.route) {
        composable(NavRoutes.FirstPartial.route) {
            FirstPartialView(navController = navController)

        }
        composable(NavRoutes.SecondPartial.route) {
            SecondPartialView(navController = navController)
        }
        composable(NavRoutes.ThirdPartial.route) {
            ThirdPartialView()
        }
        composable(NavRoutes.PadelScore.route) {
            PadelScoreView(navController = navController)
        }
        composable(NavRoutes.EvenOdd.route) {
            EvenOddView(navController = navController, viewModel = EvenOrOddViewModel())
        }
        composable(NavRoutes.Cards.route) {
            CardsView(navController = navController, viewModel = CardsViewModel())
        }
        composable(NavRoutes.Compare.route) {
            NumberComparatorView(
                navController = navController,
                viewModel = NumberComparatorViewModel()
            )
        }
        composable(NavRoutes.Barber.route) {
            BarberView(navController = navController, viewModel = BarberViewModel())
        }
        composable(NavRoutes.Apple.route) {
            ApplesView(viewModel = ApplesViewModel())
        }
        composable(NavRoutes.Listas.route) {
            ListasView(navController = navController)
        }
        composable(NavRoutes.Qr.route) {
            QrView()
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

@androidx.camera.core.ExperimentalGetImage

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PDM123fTheme {
        MainScreen()
    }
}



