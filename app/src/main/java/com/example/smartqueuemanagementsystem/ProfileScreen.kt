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
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


// ====================================================
// COLORS
// ====================================================

private val DeepNavy = Color(0xFF0B3954)
private val MainBlue = Color(0xFF168BC4)

private val ScreenBackground = Color(0xFFF4FAFD)
private val LightBlue = Color(0xFFEAF7FC)

private val MainText = Color(0xFF163447)
private val SecondaryText = Color(0xFF718A99)

private val SuccessBackground = Color(0xFFE9F8F1)
private val SuccessGreen = Color(0xFF20A477)

private val DividerColor = Color(0xFFE7F0F4)


// ====================================================
// PROFILE SCREEN
// ====================================================

@Composable
fun ProfileScreen(
    paddingValues: PaddingValues
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ScreenBackground)
            .padding(paddingValues)
            .verticalScroll(rememberScrollState())
            .navigationBarsPadding()
            .padding(horizontal = 20.dp)
    ) {

        // =================================================
        // HEADER
        // =================================================

        Spacer(
            modifier = Modifier.height(18.dp)
        )

        Text(
            text = "Profile",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = DeepNavy
        )

        Spacer(
            modifier = Modifier.height(4.dp)
        )

        Text(
            text = "Your university account",
            fontSize = 15.sp,
            color = SecondaryText
        )


        Spacer(
            modifier = Modifier.height(20.dp)
        )


        // =================================================
        // PROFILE CARD
        // =================================================

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 6.dp,
                    shape = RoundedCornerShape(26.dp)
                ),

            shape = RoundedCornerShape(26.dp),

            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 24.dp,
                        vertical = 22.dp
                    ),

                horizontalAlignment =
                    Alignment.CenterHorizontally
            ) {

                // -----------------------------------------
                // AVATAR
                // -----------------------------------------

                Box(
                    modifier = Modifier
                        .size(92.dp)
                        .clip(CircleShape)
                        .background(LightBlue),

                    contentAlignment =
                        Alignment.Center
                ) {

                    Text(
                        text = "👩🏻‍🎓",
                        fontSize = 55.sp
                    )
                }


                Spacer(
                    modifier = Modifier.height(12.dp)
                )


                // -----------------------------------------
                // NAME
                // -----------------------------------------

                Text(
                    text = "Afifa Shahid",
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Bold,
                    color = DeepNavy
                )


                Spacer(
                    modifier = Modifier.height(4.dp)
                )


                Text(
                    text = "University Student",
                    fontSize = 14.sp,
                    color = SecondaryText
                )


                Spacer(
                    modifier = Modifier.height(14.dp)
                )


                // -----------------------------------------
                // ACTIVE STATUS
                // -----------------------------------------

                Box(
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(50.dp)
                        )
                        .background(
                            SuccessBackground
                        )
                        .padding(
                            horizontal = 16.dp,
                            vertical = 8.dp
                        )
                ) {

                    Text(
                        text = "●  Queue Member",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = SuccessGreen
                    )
                }
            }
        }


        Spacer(
            modifier = Modifier.height(24.dp)
        )


        // =================================================
        // PERSONAL INFORMATION TITLE
        // =================================================

        Text(
            text = "Personal Information",
            fontSize = 21.sp,
            fontWeight = FontWeight.Bold,
            color = DeepNavy
        )

        Spacer(
            modifier = Modifier.height(11.dp)
        )


        // =================================================
        // PERSONAL INFORMATION CARD
        // =================================================

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 4.dp,
                    shape = RoundedCornerShape(22.dp)
                ),

            shape = RoundedCornerShape(22.dp),

            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {

                ProfileInfoRow(
                    icon = Icons.Default.Person,
                    title = "Full Name",
                    value = "Afifa Shahid"
                )

                HorizontalDivider(
                    modifier = Modifier.padding(
                        vertical = 15.dp
                    ),
                    thickness = 1.dp,
                    color = DividerColor
                )

                ProfileInfoRow(
                    icon = Icons.Default.Badge,
                    title = "Student ID",
                    value = "ST-2026-050"
                )

                HorizontalDivider(
                    modifier = Modifier.padding(
                        vertical = 15.dp
                    ),
                    thickness = 1.dp,
                    color = DividerColor
                )

                ProfileInfoRow(
                    icon = Icons.Default.School,
                    title = "Program",
                    value = "Computer Science"
                )

                HorizontalDivider(
                    modifier = Modifier.padding(
                        vertical = 15.dp
                    ),
                    thickness = 1.dp,
                    color = DividerColor
                )

                ProfileInfoRow(
                    icon = Icons.Default.Email,
                    title = "Email",
                    value = "afifa@student.edu"
                )
            }
        }


        Spacer(
            modifier = Modifier.height(24.dp)
        )


        // =================================================
        // QUEUE ACCOUNT TITLE
        // =================================================

        Text(
            text = "Queue Account",
            fontSize = 21.sp,
            fontWeight = FontWeight.Bold,
            color = DeepNavy
        )

        Spacer(
            modifier = Modifier.height(11.dp)
        )


        // =================================================
        // QUEUE ACCOUNT CARD
        // =================================================

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 4.dp,
                    shape = RoundedCornerShape(22.dp)
                ),

            shape = RoundedCornerShape(22.dp),

            colors = CardDefaults.cardColors(
                containerColor = LightBlue
            )
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),

                verticalAlignment =
                    Alignment.CenterVertically
            ) {

                // -----------------------------------------
                // ICON
                // -----------------------------------------

                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .clip(
                            RoundedCornerShape(15.dp)
                        )
                        .background(Color.White),

                    contentAlignment =
                        Alignment.Center
                ) {

                    Icon(
                        imageVector =
                            Icons.Default.Badge,

                        contentDescription = null,

                        tint = MainBlue,

                        modifier = Modifier.size(25.dp)
                    )
                }


                Spacer(
                    modifier = Modifier.size(14.dp)
                )


                // -----------------------------------------
                // TEXT
                // -----------------------------------------

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = "Queue Access",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = MainText
                    )

                    Spacer(
                        modifier = Modifier.height(3.dp)
                    )

                    Text(
                        text = "Active and ready to join queues",
                        fontSize = 13.sp,
                        color = SecondaryText
                    )
                }
            }
        }


        // =================================================
        // BOTTOM NAVIGATION CLEARANCE
        // =================================================

        Spacer(
            modifier = Modifier.height(110.dp)
        )
    }
}


// ====================================================
// PROFILE INFORMATION ROW
// ====================================================

@Composable
private fun ProfileInfoRow(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    value: String
) {

    Row(
        modifier = Modifier.fillMaxWidth(),

        verticalAlignment =
            Alignment.CenterVertically
    ) {

        // -----------------------------------------
        // ICON BACKGROUND
        // -----------------------------------------

        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(
                    RoundedCornerShape(15.dp)
                )
                .background(LightBlue),

            contentAlignment =
                Alignment.Center
        ) {

            Icon(
                imageVector = icon,

                contentDescription = null,

                tint = MainBlue,

                modifier = Modifier.size(23.dp)
            )
        }


        Spacer(
            modifier = Modifier.size(14.dp)
        )


        // -----------------------------------------
        // INFORMATION
        // -----------------------------------------

        Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(
                text = title,
                fontSize = 12.sp,
                color = SecondaryText
            )

            Spacer(
                modifier = Modifier.height(2.dp)
            )

            Text(
                text = value,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = MainText
            )
        }
    }
}