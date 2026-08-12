package com.example.smartqueuemanagementsystem

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ConfirmationNumber
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
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

private val CardWhite = Color.White

private val SuccessBackground = Color(0xFFE9F8F1)
private val SuccessGreen = Color(0xFF20A477)


// ====================================================
// QUEUE DETAILS SCREEN
// ====================================================

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QueueDetailsScreen(
    department: Department,
    onBackClick: () -> Unit
) {

    // ------------------------------------------------
    // SYSTEM BACK BUTTON
    // ------------------------------------------------

    BackHandler {
        onBackClick()
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ScreenBackground)
    ) {

        // =================================================
        // TOP BAR
        // =================================================

        TopAppBar(

            title = {

                Text(
                    text = "Queue Details",
                    fontWeight = FontWeight.Bold,
                    color = DeepNavy
                )
            },

            navigationIcon = {

                IconButton(
                    onClick = onBackClick
                ) {

                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = DeepNavy
                    )
                }
            }
        )


        // =================================================
        // MAIN CONTENT
        // =================================================

        Column(

            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
        ) {

            // =================================================
            // DEPARTMENT HEADER
            // =================================================

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                // Department icon

                Box(
                    modifier = Modifier
                        .size(62.dp)
                        .clip(
                            RoundedCornerShape(18.dp)
                        )
                        .background(LightBlue),

                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = department.icon,
                        fontSize = 34.sp
                    )
                }


                Spacer(
                    modifier = Modifier.size(14.dp)
                )


                Column {

                    Text(
                        text = department.name,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        color = DeepNavy
                    )

                    Spacer(
                        modifier = Modifier.height(3.dp)
                    )

                    Text(
                        text = "Live queue information",
                        fontSize = 13.sp,
                        color = SecondaryText
                    )
                }
            }


            Spacer(
                modifier = Modifier.height(22.dp)
            )


            // =================================================
            // CURRENT TOKEN - PREMIUM GRADIENT CARD
            // =================================================

            Box(

                modifier = Modifier
                    .fillMaxWidth()
                    .height(230.dp)
                    .clip(
                        RoundedCornerShape(26.dp)
                    )
                    .shadow(
                        elevation = 8.dp,
                        shape = RoundedCornerShape(26.dp)
                    )
                    .background(

                        brush = Brush.linearGradient(

                            colors = listOf(
                                DeepNavy,
                                MainBlue,
                                BrightBlue
                            )
                        )
                    )
            ) {

                // ------------------------------------------------
                // TOP RIGHT DECORATIVE CIRCLE
                // ------------------------------------------------

                Box(
                    modifier = Modifier
                        .size(155.dp)
                        .offset(
                            x = 245.dp,
                            y = (-45).dp
                        )
                        .clip(CircleShape)
                        .background(
                            Color.White.copy(
                                alpha = 0.08f
                            )
                        )
                )


                // ------------------------------------------------
                // BOTTOM LEFT DECORATIVE CIRCLE
                // ------------------------------------------------

                Box(
                    modifier = Modifier
                        .size(95.dp)
                        .offset(
                            x = (-35).dp,
                            y = 160.dp
                        )
                        .clip(CircleShape)
                        .background(
                            Color.White.copy(
                                alpha = 0.07f
                            )
                        )
                )


                // ------------------------------------------------
                // CARD CONTENT
                // ------------------------------------------------

                Column(

                    modifier = Modifier
                        .fillMaxSize()
                        .padding(22.dp),

                    horizontalAlignment =
                        Alignment.CenterHorizontally,

                    verticalArrangement =
                        Arrangement.Center
                ) {

                    // Token icon

                    Box(

                        modifier = Modifier
                            .size(42.dp)
                            .clip(CircleShape)
                            .background(
                                Color.White.copy(
                                    alpha = 0.15f
                                )
                            ),

                        contentAlignment =
                            Alignment.Center
                    ) {

                        Icon(
                            imageVector =
                                Icons.Default.ConfirmationNumber,

                            contentDescription =
                                "Current Token",

                            tint = Color.White,

                            modifier = Modifier.size(22.dp)
                        )
                    }


                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )


                    Text(
                        text = "CURRENT TOKEN",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White.copy(
                            alpha = 0.78f
                        )
                    )


                    Spacer(
                        modifier = Modifier.height(2.dp)
                    )


                    Text(
                        text = "${department.currentToken}",
                        fontSize = 52.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White
                    )


                    Text(
                        text = "Now serving",
                        fontSize = 13.sp,
                        color = Color.White.copy(
                            alpha = 0.78f
                        )
                    )
                }
            }


            Spacer(
                modifier = Modifier.height(16.dp)
            )


            // =================================================
            // QUEUE INFORMATION CARD
            // =================================================

            Card(

                modifier = Modifier
                    .fillMaxWidth(),

                shape = RoundedCornerShape(22.dp),

                colors = CardDefaults.cardColors(
                    containerColor = CardWhite
                ),

                elevation = CardDefaults.cardElevation(
                    defaultElevation = 5.dp
                )
            ) {

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    // ---------------------------------------------
                    // YOUR TOKEN
                    // ---------------------------------------------

                    QueueInfoRow(
                        icon = Icons.Default.ConfirmationNumber,
                        title = "Your Token",
                        value = "A-${department.userToken}"
                    )


                    Spacer(
                        modifier = Modifier.height(18.dp)
                    )


                    // ---------------------------------------------
                    // PEOPLE AHEAD
                    // ---------------------------------------------

                    QueueInfoRow(
                        icon = Icons.Default.People,
                        title = "People Ahead",
                        value = "${department.waitingPeople}"
                    )


                    Spacer(
                        modifier = Modifier.height(18.dp)
                    )


                    // ---------------------------------------------
                    // ESTIMATED WAIT
                    // ---------------------------------------------

                    QueueInfoRow(
                        icon = Icons.Default.Schedule,
                        title = "Estimated Wait",
                        value = "${department.waitingPeople * 5} min"
                    )
                }
            }


            Spacer(
                modifier = Modifier.height(16.dp)
            )


            // =================================================
            // ACTIVE STATUS CARD
            // =================================================

            Card(

                modifier = Modifier
                    .fillMaxWidth(),

                shape = RoundedCornerShape(20.dp),

                colors = CardDefaults.cardColors(
                    containerColor = SuccessBackground
                ),

                elevation = CardDefaults.cardElevation(
                    defaultElevation = 1.dp
                )
            ) {

                Row(

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(17.dp),

                    verticalAlignment =
                        Alignment.CenterVertically
                ) {

                    // ---------------------------------------------
                    // CHECK CIRCLE
                    // ---------------------------------------------

                    Box(

                        modifier = Modifier
                            .size(42.dp)
                            .clip(CircleShape)
                            .background(
                                SuccessGreen.copy(
                                    alpha = 0.15f
                                )
                            ),

                        contentAlignment =
                            Alignment.Center
                    ) {

                        Text(
                            text = "✓",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = SuccessGreen
                        )
                    }


                    Spacer(
                        modifier = Modifier.size(12.dp)
                    )


                    Column {

                        Text(
                            text = "Your token is active",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = SuccessGreen
                        )

                        Spacer(
                            modifier = Modifier.height(2.dp)
                        )

                        Text(
                            text = "Please wait for your turn.",
                            fontSize = 12.sp,
                            color = SuccessGreen.copy(
                                alpha = 0.8f
                            )
                        )
                    }
                }
            }
        }
    }
}


// ====================================================
// QUEUE INFORMATION ROW
// ====================================================

@Composable
fun QueueInfoRow(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    value: String
) {

    Row(

        modifier = Modifier.fillMaxWidth(),

        verticalAlignment =
            Alignment.CenterVertically
    ) {

        // ------------------------------------------------
        // ICON
        // ------------------------------------------------

        Box(

            modifier = Modifier
                .size(42.dp)
                .clip(
                    RoundedCornerShape(13.dp)
                )
                .background(LightBlue),

            contentAlignment =
                Alignment.Center
        ) {

            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = MainBlue,
                modifier = Modifier.size(21.dp)
            )
        }


        Spacer(
            modifier = Modifier.size(12.dp)
        )


        // ------------------------------------------------
        // TITLE
        // ------------------------------------------------

        Text(
            text = title,
            fontSize = 14.sp,
            color = SecondaryText,
            modifier = Modifier.weight(1f)
        )


        // ------------------------------------------------
        // VALUE
        // ------------------------------------------------

        Text(
            text = value,
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold,
            color = MainText
        )
    }
}