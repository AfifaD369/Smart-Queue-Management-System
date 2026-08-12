package com.example.smartqueuemanagementsystem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ConfirmationNumber
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            Surface(
                color = MaterialTheme.colorScheme.background
            ) {

                SmartQueueSplashScreen()
            }
        }
    }
}


// ====================================================
// SPLASH SCREEN
// ====================================================

@Composable
fun SmartQueueSplashScreen() {

    var showSplash by remember {
        mutableStateOf(true)
    }

    LaunchedEffect(Unit) {

        delay(1800)

        showSplash = false
    }

    if (showSplash) {

        SplashContent()

    } else {

        SmartQueueApp()
    }
}


// ====================================================
// SPLASH CONTENT
// ====================================================

@Composable
private fun SplashContent() {

    val DeepNavy = Color(0xFF082F49)
    val MainBlue = Color(0xFF168BC4)
    val BrightBlue = Color(0xFF29A9E8)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        DeepNavy,
                        MainBlue,
                        BrightBlue
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp),

            horizontalAlignment = Alignment.CenterHorizontally,

            verticalArrangement = Arrangement.Center
        ) {

            // =========================================
            // APP ICON
            // =========================================

            Box(
                modifier = Modifier
                    .size(105.dp)
                    .clip(
                        RoundedCornerShape(30.dp)
                    )
                    .background(
                        Color.White.copy(alpha = 0.13f)
                    ),

                contentAlignment = Alignment.Center
            ) {

                Box(
                    modifier = Modifier
                        .size(78.dp)
                        .clip(
                            RoundedCornerShape(24.dp)
                        )
                        .background(Color.White),

                    contentAlignment = Alignment.Center
                ) {

                    Icon(
                        imageVector =
                            Icons.Default.ConfirmationNumber,

                        contentDescription =
                            "Smart Queue",

                        tint = MainBlue,

                        modifier = Modifier.size(43.dp)
                    )
                }
            }


            Spacer(
                modifier = Modifier.height(28.dp)
            )


            // =========================================
            // APP NAME
            // =========================================

            Text(
                text = "Smart Queue",

                fontSize = 34.sp,

                fontWeight =
                    FontWeight.ExtraBold,

                color = Color.White
            )


            Spacer(
                modifier = Modifier.height(8.dp)
            )


            // =========================================
            // SMALL CATEGORY TEXT
            // =========================================

            Text(
                text = "UNIVERSITY QUEUE MANAGEMENT",

                fontSize = 11.sp,

                fontWeight =
                    FontWeight.Bold,

                letterSpacing = 1.5.sp,

                color =
                    Color.White.copy(
                        alpha = 0.75f
                    )
            )


            Spacer(
                modifier = Modifier.height(14.dp)
            )


            // =========================================
            // DESCRIPTION
            // =========================================

            Text(
                text =
                    "Manage your university queues easily",

                fontSize = 14.sp,

                color =
                    Color.White.copy(
                        alpha = 0.82f
                    )
            )


            Spacer(
                modifier = Modifier.height(38.dp)
            )


            // =========================================
            // LOADING INDICATOR
            // =========================================

            Box(
                modifier = Modifier
                    .size(38.dp)
                    .clip(CircleShape)
                    .background(
                        Color.White.copy(
                            alpha = 0.12f
                        )
                    ),

                contentAlignment =
                    Alignment.Center
            ) {

                Text(
                    text = "•",

                    fontSize = 24.sp,

                    fontWeight =
                        FontWeight.Bold,

                    color = Color.White
                )
            }
        }


        // =============================================
        // VERSION
        // =============================================

        Text(
            text = "Smart Queue • 2026",

            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 35.dp),

            fontSize = 11.sp,

            color =
                Color.White.copy(
                    alpha = 0.55f
                )
        )
    }
}