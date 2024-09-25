package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Box(Modifier.background(Color(0xFF52796F))) {
        Introduction(
            profilePicture = painterResource(R.drawable.yoda_the_empire_strikes_back_28a7558),
            fullName = "Irakli Iobashvili",
            title = "Android app developer",
        )
        BusinessInfo(
            number = "510 10 10 10",
            email = "iraklyoda42@gmail.com",
            share = "@iraklyoda"
        )
    }
}

@Composable
fun Introduction(
    profilePicture: Painter,
    fullName: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(start = 8.dp, end = 8.dp).fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = profilePicture,
            contentDescription = "Profile Picture",
            modifier
                .size(180.dp)
                .padding(20.dp)
                .clip(CircleShape)
                .border(2.dp, Color.LightGray, CircleShape),
            contentScale = ContentScale.Crop,
            )
        Text(
            text = fullName,
            fontSize = 24.sp,
            color = Color.White
        )
        Text(
            text = title,
            fontSize = 12.sp,
            color = Color.White
        )
    }
}

@Composable
fun BusinessInfoPart(
    icon: ImageVector,
    info: String,
    modifier: Modifier = Modifier
){
    Row(Modifier.fillMaxWidth(0.6f).padding(4.dp)) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier.weight(0.3f),
            tint = Color(0xFFF9DEC9)
        )
        Text(
            text = info,
            fontSize = 12.sp,
            textAlign = TextAlign.Start,
            modifier = Modifier.weight(0.7f),
            color = Color(0xFFF9DEC9)
        )
    }
}

@Composable
fun BusinessInfo(
    number: String,
    email: String,
    share: String
){
    Column(
        Modifier.fillMaxSize().padding(bottom = 36.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BusinessInfoPart(icon = Icons.Filled.Call, info = number)
        BusinessInfoPart(icon = Icons.Filled.Email, info = email)
        BusinessInfoPart(icon = Icons.Filled.Share, info = share)
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        Box() {
            Introduction(
                profilePicture = painterResource(R.drawable.yoda_the_empire_strikes_back_28a7558),
                fullName = "Irakli Iobashvili",
                title = "Android app developer",
            )
            BusinessInfo(
                number = "510 10 10 10",
                email = "iraklyoda42@gmail.com",
                share = "@iraklyoda"
            )
        }
    }
}