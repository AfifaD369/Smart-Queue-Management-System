package com.example.smartqueuemanagementsystem

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ConfirmationNumber
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


// ====================================================
// COLORS
// ====================================================

private val DeepNavy = Color(0xFF0B3954)
private val MainBlue = Color(0xFF168BC4)
private val BrightBlue = Color(0xFF29A9E8)

private val ScreenBackground = Color(0xFFF4FAFD)
private val LightBlue = Color(0xFFEAF7FC)

private val MainText = Color(0xFF163447)
private val SecondaryText = Color(0xFF718A99)


// ====================================================
// MY TOKEN SCREEN
// ====================================================

@Composable
fun MyTokenScreen(
    paddingValues: PaddingValues,
    department: Department
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ScreenBackground)
            .padding(paddingValues)
            .padding(horizontal = 22.dp)
    ) {

        // =================================================
        // HEADER
        // =================================================

        Spacer(
            modifier = Modifier.height(25.dp)
        )

        Text(
            text = "My Token",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = DeepNavy
        )

        Spacer(
            modifier = Modifier.height(5.dp)
        )

        Text(
            text = "You are currently in the queue",
            fontSize = 15.sp,
            color = SecondaryText
        )


        Spacer(
            modifier = Modifier.height(30.dp)
        )


        // =================================================
        // TOKEN CARD
        // =================================================

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 10.dp,
                    shape = RoundedCornerShape(32.dp)
                )
                .clip(
                    RoundedCornerShape(32.dp)
                )
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            DeepNavy,
                            MainBlue
                        )
                    )
                )
                .padding(30.dp),

            contentAlignment =
                Alignment.Center
        ) {

            Column(
                horizontalAlignment =
                    Alignment.CenterHorizontally
            ) {

                Text(
                    text = "YOUR TOKEN NUMBER",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White.copy(alpha = 0.7f),
                    letterSpacing = 1.sp
                )

                Spacer(
                    modifier = Modifier.height(10.dp)
                )

                Text(
                    text = "${department.name[0]}-${department.userToken}",
                    fontSize = 60.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White
                )

                Spacer(
                    modifier = Modifier.height(20.dp)
                )

                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(
                            Color.White.copy(alpha = 0.15f)
                        )
                        .padding(
                            horizontal = 20.dp,
                            vertical = 8.dp
                        )
                ) {

                    Text(
                        text = department.name,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                }
            }
        }


        Spacer(
            modifier = Modifier.height(35.dp)
        )


        // =================================================
        // QUEUE STATS
        // =================================================

        Row(
            modifier = Modifier.fillMaxWidth(),

            horizontalArrangement =
                Arrangement.spacedBy(15.dp)
        ) {

            // ---------------------------------------------
            // CURRENT SERVING
            // ---------------------------------------------

            StatCard(
                modifier = Modifier.weight(1f),
                label = "Now Serving",
                value = "${department.currentToken}",
                icon = Icons.Default.ConfirmationNumber,
                iconColor = MainBlue
            )


            // ---------------------------------------------
            // ESTIMATED TIME
            // ---------------------------------------------

            val waitTime = (department.userToken - department.currentToken) * 5

            StatCard(
                modifier = Modifier.weight(1f),
                label = "Est. Wait",
                value = "$waitTime min",
                icon = Icons.Default.Timer,
                iconColor = BrightBlue
            )
        }


        Spacer(
            modifier = Modifier.height(25.dp)
        )


        // =================================================
        // INFO CARD
        // =================================================

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 2.dp,
                    shape = RoundedCornerShape(20.dp)
                ),

            shape = RoundedCornerShape(20.dp),

            colors = CardDefaults.cardColors(
                containerColor = LightBlue.copy(alpha = 0.6f)
            )
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),

                verticalAlignment =
                    Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = null,
                    tint = DeepNavy,
                    modifier = Modifier.size(24.dp)
                )

                Spacer(
                    modifier = Modifier.width(15.dp)
                )

                Text(
                    text = "Please reach the counter when your token is called. Make sure to have your documents ready.",
                    fontSize = 13.sp,
                    color = MainText,
                    lineHeight = 18.sp
                )
            }
        }
    }
}


// ======================================================
// STAT CARD
// ======================================================

@Composable
private fun StatCard(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    iconColor: Color
) {

    Card(
        modifier = modifier
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(24.dp)
            ),

        shape = RoundedCornerShape(24.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {

        Column(
            modifier = Modifier
                .padding(20.dp),

            horizontalAlignment =
                Alignment.Start
        ) {

            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(iconColor.copy(alpha = 0.1f)),

                contentAlignment =
                    Alignment.Center
            ) {

                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = iconColor,
                    modifier = Modifier.size(20.dp)
                )
            }

            Spacer(
                modifier = Modifier.height(15.dp)
            )

            Text(
                text = label,
                fontSize = 12.sp,
                color = SecondaryText,
                fontWeight = FontWeight.Medium
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Text(
                text = value,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = DeepNavy
            )
        }
    }
}