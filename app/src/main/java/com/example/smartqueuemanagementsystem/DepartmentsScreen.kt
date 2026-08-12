package com.example.smartqueuemanagementsystem

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
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
private val BrightBlue = Color(0xFF29A9E8)

private val ScreenBackground = Color(0xFFF4FAFD)
private val LightBlue = Color(0xFFEAF7FC)

private val MainText = Color(0xFF163447)
private val SecondaryText = Color(0xFF718A99)

private val CardWhite = Color.White

private val DividerColor = Color(0xFFE0EDF2)


// ====================================================
// DEPARTMENTS SCREEN
// ====================================================

@Composable
fun DepartmentsScreen(
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
            top = 22.dp,
            bottom = 105.dp
        ),

        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        // =================================================
        // HEADER
        // =================================================

        item {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {

                Text(
                    text = "Departments",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = DeepNavy
                )

                Spacer(
                    modifier = Modifier.height(5.dp)
                )

                Text(
                    text = "Choose a department to view its queue",
                    fontSize = 15.sp,
                    color = SecondaryText
                )
            }
        }


        // =================================================
        // DEPARTMENT LAZY ROW
        // =================================================

        item {

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            LazyRow(

                contentPadding = PaddingValues(
                    horizontal = 20.dp
                ),

                horizontalArrangement =
                    Arrangement.spacedBy(12.dp)
            ) {

                items(
                    items = departments,
                    key = { it.id }
                ) { department ->

                    DepartmentCard(
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


        // =================================================
        // ALL ACTIVE QUEUES TITLE
        // =================================================

        item {

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {

                Text(
                    text = "All Active Queues",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = DeepNavy
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                HorizontalDivider(
                    color = DividerColor,
                    thickness = 1.dp
                )
            }
        }


        // =================================================
        // ACTIVE QUEUE LIST
        // =================================================

        items(
            items = departments,
            key = { "queue_${it.id}" }
        ) { department ->

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {

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
}


// ======================================================
// DEPARTMENT CARD - LAZY ROW
// ======================================================

@Composable
fun DepartmentCard(
    department: Department,
    onClick: () -> Unit
) {

    Card(

        onClick = onClick,

        modifier = Modifier
            .size(
                width = 116.dp,
                height = 124.dp
            )
            .shadow(
                elevation = 4.dp,
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

            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),

            horizontalAlignment =
                Alignment.CenterHorizontally,

            verticalArrangement =
                Arrangement.Center
        ) {

            // =============================================
            // ICON BACKGROUND
            // =============================================

            Column(

                modifier = Modifier
                    .size(66.dp)
                    .clip(
                        RoundedCornerShape(18.dp)
                    )
                    .background(LightBlue),

                horizontalAlignment =
                    Alignment.CenterHorizontally,

                verticalArrangement =
                    Arrangement.Center
            ) {

                Text(
                    text = department.icon,
                    fontSize = 34.sp
                )
            }


            Spacer(
                modifier = Modifier.height(8.dp)
            )


            // =============================================
            // DEPARTMENT NAME
            // =============================================

            Text(
                text = department.name,

                fontSize = 14.sp,

                fontWeight =
                    FontWeight.Bold,

                color = MainText,

                maxLines = 2
            )
        }
    }
}