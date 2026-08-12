package com.example.smartqueuemanagementsystem

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.ConfirmationNumber
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument


// ====================================================
// NAVIGATION SCREENS
// ====================================================

sealed class Screen(val route: String) {

    object Dashboard : Screen("dashboard")

    object Departments : Screen("departments")

    object MyToken : Screen("my_token")

    object Profile : Screen("profile")

    object QueueDetails : Screen("queue_details/{departmentId}") {

        fun createRoute(departmentId: Int): String {
            return "queue_details/$departmentId"
        }
    }
}


// ====================================================
// COLORS
// ====================================================

private val MainBlue = Color(0xFF168BC4)
private val BrightBlue = Color(0xFF29A9E8)
private val NavigationGray = Color(0xFF718A99)
private val NavigationBackground = Color.White


// ====================================================
// SMART QUEUE APP
// ====================================================

@Composable
fun SmartQueueApp() {

    val navController = rememberNavController()


    // =================================================
    // DEPARTMENTS DATA
    // =================================================

    val departments = listOf(

        Department(
            id = 1,
            name = "Admissions",
            icon = "🎓",
            currentToken = 42,
            waitingPeople = 8,
            userToken = 50
        ),

        Department(
            id = 2,
            name = "Accounts",
            icon = "💰",
            currentToken = 25,
            waitingPeople = 5,
            userToken = 30
        ),

        Department(
            id = 3,
            name = "Examination",
            icon = "📝",
            currentToken = 67,
            waitingPeople = 4,
            userToken = 71
        ),

        Department(
            id = 4,
            name = "Library",
            icon = "📚",
            currentToken = 18,
            waitingPeople = 3,
            userToken = 21
        ),

        Department(
            id = 5,
            name = "Student Affairs",
            icon = "👨‍🎓",
            currentToken = 33,
            waitingPeople = 6,
            userToken = 39
        )
    )


    // =================================================
    // CURRENT ROUTE
    // =================================================

    val backStackEntry by
    navController.currentBackStackEntryAsState()

    val currentRoute =
        backStackEntry?.destination?.route


    // =================================================
    // SHOW BOTTOM NAVIGATION
    // =================================================

    val showBottomBar =
        currentRoute == Screen.Dashboard.route ||
                currentRoute == Screen.Departments.route ||
                currentRoute == Screen.MyToken.route ||
                currentRoute == Screen.Profile.route


    // =================================================
    // SCAFFOLD
    // =================================================

    Scaffold(

        bottomBar = {

            if (showBottomBar) {

                // =========================================
                // POLISHED BOTTOM NAVIGATION
                // =========================================

                NavigationBar(

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 12.dp,
                            vertical = 8.dp
                        )
                        .shadow(
                            elevation = 8.dp,
                            shape = RoundedCornerShape(24.dp)
                        )
                        .clip(
                            RoundedCornerShape(24.dp)
                        )
                        .background(
                            NavigationBackground
                        ),

                    containerColor =
                        NavigationBackground,

                    tonalElevation = 0.dp
                ) {


                    // =====================================
                    // HOME
                    // =====================================

                    NavigationBarItem(

                        selected =
                            currentRoute ==
                                    Screen.Dashboard.route,

                        onClick = {

                            navController.navigate(
                                Screen.Dashboard.route
                            ) {

                                popUpTo(
                                    Screen.Dashboard.route
                                ) {
                                    inclusive = true
                                }

                                launchSingleTop = true
                            }
                        },

                        icon = {

                            Icon(
                                imageVector =
                                    Icons.Default.Home,

                                contentDescription =
                                    "Home"
                            )
                        },

                        label = {

                            Text(
                                text = "Home",
                                fontSize = 11.sp
                            )
                        },

                        colors =
                            NavigationBarItemDefaults.colors(

                                selectedIconColor =
                                    Color.White,

                                selectedTextColor =
                                    MainBlue,

                                indicatorColor =
                                    MainBlue,

                                unselectedIconColor =
                                    NavigationGray,

                                unselectedTextColor =
                                    NavigationGray
                            )
                    )


                    // =====================================
                    // DEPARTMENTS
                    // =====================================

                    NavigationBarItem(

                        selected =
                            currentRoute ==
                                    Screen.Departments.route,

                        onClick = {

                            navController.navigate(
                                Screen.Departments.route
                            ) {

                                launchSingleTop = true
                            }
                        },

                        icon = {

                            Icon(
                                imageVector =
                                    Icons.Default.Business,

                                contentDescription =
                                    "Departments"
                            )
                        },

                        label = {

                            Text(
                                text = "Departments",
                                fontSize = 11.sp
                            )
                        },

                        colors =
                            NavigationBarItemDefaults.colors(

                                selectedIconColor =
                                    Color.White,

                                selectedTextColor =
                                    MainBlue,

                                indicatorColor =
                                    MainBlue,

                                unselectedIconColor =
                                    NavigationGray,

                                unselectedTextColor =
                                    NavigationGray
                            )
                    )


                    // =====================================
                    // MY TOKEN
                    // =====================================

                    NavigationBarItem(

                        selected =
                            currentRoute ==
                                    Screen.MyToken.route,

                        onClick = {

                            navController.navigate(
                                Screen.MyToken.route
                            ) {

                                launchSingleTop = true
                            }
                        },

                        icon = {

                            Icon(
                                imageVector =
                                    Icons.Default.ConfirmationNumber,

                                contentDescription =
                                    "My Token"
                            )
                        },

                        label = {

                            Text(
                                text = "My Token",
                                fontSize = 11.sp
                            )
                        },

                        colors =
                            NavigationBarItemDefaults.colors(

                                selectedIconColor =
                                    Color.White,

                                selectedTextColor =
                                    MainBlue,

                                indicatorColor =
                                    MainBlue,

                                unselectedIconColor =
                                    NavigationGray,

                                unselectedTextColor =
                                    NavigationGray
                            )
                    )


                    // =====================================
                    // PROFILE
                    // =====================================

                    NavigationBarItem(

                        selected =
                            currentRoute ==
                                    Screen.Profile.route,

                        onClick = {

                            navController.navigate(
                                Screen.Profile.route
                            ) {

                                launchSingleTop = true
                            }
                        },

                        icon = {

                            Icon(
                                imageVector =
                                    Icons.Default.Person,

                                contentDescription =
                                    "Profile"
                            )
                        },

                        label = {

                            Text(
                                text = "Profile",
                                fontSize = 11.sp
                            )
                        },

                        colors =
                            NavigationBarItemDefaults.colors(

                                selectedIconColor =
                                    Color.White,

                                selectedTextColor =
                                    MainBlue,

                                indicatorColor =
                                    MainBlue,

                                unselectedIconColor =
                                    NavigationGray,

                                unselectedTextColor =
                                    NavigationGray
                            )
                    )
                }
            }
        }
    ) { paddingValues ->


        // =================================================
        // NAVIGATION HOST
        // =================================================

        NavHost(

            navController =
                navController,

            startDestination =
                Screen.Dashboard.route
        ) {


            // =============================================
            // DASHBOARD
            // =============================================

            composable(
                Screen.Dashboard.route
            ) {

                DashboardScreen(

                    paddingValues =
                        paddingValues,

                    departments =
                        departments,

                    onDepartmentClick = { departmentId ->

                        navController.navigate(
                            Screen.QueueDetails
                                .createRoute(
                                    departmentId
                                )
                        )
                    }
                )
            }


            // =============================================
            // DEPARTMENTS
            // =============================================

            composable(
                Screen.Departments.route
            ) {

                DepartmentsScreen(

                    paddingValues =
                        paddingValues,

                    departments =
                        departments,

                    onDepartmentClick = { departmentId ->

                        navController.navigate(
                            Screen.QueueDetails
                                .createRoute(
                                    departmentId
                                )
                        )
                    }
                )
            }


            // =============================================
            // MY TOKEN
            // =============================================

            composable(
                Screen.MyToken.route
            ) {

                MyTokenScreen(

                    paddingValues =
                        paddingValues,

                    department =
                        departments[0]
                )
            }


            // =============================================
            // PROFILE
            // =============================================

            composable(
                Screen.Profile.route
            ) {

                ProfileScreen(
                    paddingValues =
                        paddingValues
                )
            }


            // =============================================
            // QUEUE DETAILS
            // =============================================

            composable(

                route =
                    Screen.QueueDetails.route,

                arguments =
                    listOf(
                        navArgument(
                            "departmentId"
                        ) {
                            type =
                                NavType.IntType
                        }
                    )
            ) { entry ->

                val departmentId =
                    entry.arguments
                        ?.getInt("departmentId")
                        ?: 1


                val department =
                    departments.find {
                        it.id == departmentId
                    }


                if (department != null) {

                    QueueDetailsScreen(

                        department =
                            department,

                        onBackClick = {

                            navController
                                .popBackStack()
                        }
                    )
                }
            }
        }
    }
}