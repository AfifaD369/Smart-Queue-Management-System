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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.ConfirmationNumber
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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

private val MainBlue = Color(0xFF168BC4)
private val BrightBlue = Color(0xFF29A9E8)
private val DeepNavy = Color(0xFF0B3954)

private val ScreenBackground = Color(0xFFF4FAFD)
private val LightBlue = Color(0xFFEAF7FC)

private val MainText = Color(0xFF163447)
private val SecondaryText = Color(0xFF718A99)

private val CardWhite = Color.White

private val DividerColor = Color(0xFFE7F0F4)


// ====================================================
// DASHBOARD SCREEN
// ====================================================

@Composable
fun DashboardScreen(
    paddingValues: PaddingValues,
    departments: List<Department>,
    onDepartmentClick: (Int) -> Unit
) {

    LazyColumn(

        modifier = Modifier
            .fillMaxSize()
            .background(ScreenBackground)
            .padding(paddingValues),

        contentPadding = PaddingValues(
            start = 20.dp,
            end = 20.dp,
            top = 22.dp,
            bottom = 105.dp
        ),

        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {

        // =================================================
        // HEADER
        // =================================================

        item {

            Column {

                Text(
                    text = "Good Evening 👋",
                    fontSize = 14.sp,
                    color = SecondaryText
                )

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                Text(
                    text = "Smart Queue",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = DeepNavy
                )

                Spacer(
                    modifier = Modifier.height(5.dp)
                )

                Text(
                    text = "Manage your university queues easily",
                    fontSize = 14.sp,
                    color = SecondaryText
                )
            }
        }


        // =================================================
        // ACTIVE TOKEN GRADIENT CARD
        // =================================================

        item {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(175.dp)
                    .shadow(
                        elevation = 7.dp,
                        shape = RoundedCornerShape(25.dp)
                    )
                    .clip(
                        RoundedCornerShape(25.dp)
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

                // -----------------------------------------
                // DECORATIVE CIRCLE - TOP RIGHT
                // -----------------------------------------

                Box(
                    modifier = Modifier
                        .size(150.dp)
                        .offset(
                            x = 235.dp,
                            y = (-55).dp
                        )
                        .clip(CircleShape)
                        .background(
                            Color.White.copy(alpha = 0.08f)
                        )
                )


                // -----------------------------------------
                // DECORATIVE CIRCLE - BOTTOM LEFT
                // -----------------------------------------

                Box(
                    modifier = Modifier
                        .size(95.dp)
                        .offset(
                            x = (-35).dp,
                            y = 120.dp
                        )
                        .clip(CircleShape)
                        .background(
                            Color.White.copy(alpha = 0.06f)
                        )
                )


                // -----------------------------------------
                // CARD CONTENT
                // -----------------------------------------

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                ) {

                    Row(
                        modifier = Modifier.fillMaxWidth(),

                        horizontalArrangement =
                            Arrangement.SpaceBetween,

                        verticalAlignment =
                            Alignment.CenterVertically
                    ) {

                        Column {

                            Text(
                                text = "ACTIVE TOKEN",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White.copy(
                                    alpha = 0.75f
                                )
                            )

                            Spacer(
                                modifier = Modifier.height(4.dp)
                            )

                            Text(
                                text = "A-050",
                                fontSize = 38.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.White
                            )
                        }


                        // ---------------------------------
                        // TOKEN ICON
                        // ---------------------------------

                        Box(
                            modifier = Modifier
                                .size(52.dp)
                                .clip(CircleShape)
                                .background(
                                    Color.White.copy(
                                        alpha = 0.14f
                                    )
                                ),

                            contentAlignment =
                                Alignment.Center
                        ) {

                            Icon(
                                imageVector =
                                    Icons.Default.ConfirmationNumber,

                                contentDescription =
                                    "Active Token",

                                tint = Color.White,

                                modifier = Modifier.size(27.dp)
                            )
                        }
                    }


                    Spacer(
                        modifier = Modifier.height(10.dp)
                    )


                    Text(
                        text = "Admissions Department",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )


                    Spacer(
                        modifier = Modifier.height(3.dp)
                    )


                    Text(
                        text = "Your queue is currently active",
                        fontSize = 12.sp,
                        color = Color.White.copy(
                            alpha = 0.75f
                        )
                    )
                }
            }
        }


        // =================================================
        // ACTIVE QUEUES TITLE
        // =================================================

        item {

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Text(
                text = "Active Queues",
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                color = DeepNavy
            )

            Spacer(
                modifier = Modifier.height(3.dp)
            )

            Text(
                text = "Select a department to view its queue",
                fontSize = 13.sp,
                color = SecondaryText
            )
        }


        // =================================================
        // DEPARTMENT QUEUES
        // =================================================

        items(
            items = departments,
            key = { it.id }
        ) { department ->

            QueueCard(
                department = department,

                onClick = {
                    onDepartmentClick(
                        department.id
                    )
                }
            )
        }
    }
}


// ====================================================
// QUEUE CARD
// ====================================================

@Composable
fun QueueCard(
    department: Department,
    onClick: () -> Unit
) {

    Card(

        onClick = onClick,

        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 3.dp,
                shape = RoundedCornerShape(20.dp)
            ),

        shape = RoundedCornerShape(20.dp),

        colors = CardDefaults.cardColors(
            containerColor = CardWhite
        ),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {

            // =============================================
            // MAIN CARD CONTENT
            // =============================================

            Row(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 15.dp,
                        vertical = 14.dp
                    ),

                verticalAlignment =
                    Alignment.CenterVertically
            ) {

                // =============================================
                // DEPARTMENT ICON
                // =============================================

                Box(
                    modifier = Modifier
                        .size(54.dp)
                        .clip(
                            RoundedCornerShape(16.dp)
                        )
                        .background(LightBlue),

                    contentAlignment =
                        Alignment.Center
                ) {

                    Text(
                        text = department.icon,
                        fontSize = 27.sp
                    )
                }


                Spacer(
                    modifier = Modifier.size(13.dp)
                )


                // =============================================
                // DEPARTMENT DETAILS
                // =============================================

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = department.name,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = MainText
                    )

                    Spacer(
                        modifier = Modifier.height(5.dp)
                    )


                    Row(
                        verticalAlignment =
                            Alignment.CenterVertically
                    ) {

                        Icon(
                            imageVector =
                                Icons.Default.Schedule,

                            contentDescription =
                                "People waiting",

                            tint = SecondaryText,

                            modifier = Modifier.size(15.dp)
                        )

                        Spacer(
                            modifier = Modifier.size(4.dp)
                        )

                        Text(
                            text =
                                "${department.waitingPeople} people waiting",

                            fontSize = 12.sp,
                            color = SecondaryText
                        )
                    }
                }


                // =============================================
                // CURRENT TOKEN
                // =============================================

                Column(
                    horizontalAlignment =
                        Alignment.End
                ) {

                    Text(
                        text = "NOW",
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Bold,
                        color = SecondaryText
                    )

                    Spacer(
                        modifier = Modifier.height(2.dp)
                    )

                    Text(
                        text =
                            "${department.currentToken}",

                        fontSize = 20.sp,

                        fontWeight =
                            FontWeight.Bold,

                        color = MainBlue
                    )
                }


                // =============================================
                // ARROW
                // =============================================

                IconButton(
                    onClick = onClick,

                    modifier = Modifier.size(36.dp)
                ) {

                    Icon(
                        imageVector =
                            Icons.Default.ArrowForward,

                        contentDescription =
                            "View queue",

                        tint = BrightBlue,

                        modifier = Modifier.size(24.dp)
                    )
                }
            }


            // =============================================
            // SUBTLE DIVIDER
            // =============================================

            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),

                thickness = 1.dp,

                color = DividerColor
            )


            // =============================================
            // SMALL BOTTOM SPACE
            // =============================================

            Spacer(
                modifier = Modifier.height(5.dp)
            )
        }
    }
}