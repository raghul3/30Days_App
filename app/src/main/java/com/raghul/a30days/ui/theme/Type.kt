package com.raghul.a30days.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.raghul.a30days.R


// Set of Material typography styles to start with

val ralewaylight = FontFamily(Font(R.font.raleway_thin))

val ralewayregular = FontFamily(Font(R.font.raleway))

val ralewaybold = FontFamily(Font(R.font.raleway_semibold))

val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = ralewaybold,
        fontWeight = FontWeight.Normal,
        fontSize = 30.sp
    ),
    displayMedium = TextStyle(
        fontFamily = ralewayregular,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp
    ),
    displaySmall = TextStyle(
        fontFamily = ralewaylight,
        fontWeight = FontWeight.Normal,
        fontSize = 6.sp
    )

)

