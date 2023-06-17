package com.example.namecard


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.namecard.ui.theme.NameCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NameCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NameCardApp()
                }
            }
        }
    }
}

@Composable
fun NameCardApp(){
    NameCard(
        logo = painterResource(R.drawable.android_logo),
        twitterIcon = painterResource(R.drawable._021_twitter_logo___blue),
        githubIcon = painterResource(R.drawable.github_mark_white),
        gmailIcon = painterResource(R.drawable.icons8_gmail_192___),
        name = "Kondo Atsushi",
        title = "Student",
        twitterId = "kHI1CRfKfuk3xld",
        githubId = "ats-kn",
        email = "atsushi.k214@gmail.com",
        backgroundColor = Color.Black
    )
}

@Composable
fun NameCard(
    logo: Painter,
    twitterIcon: Painter,
    githubIcon: Painter,
    gmailIcon: Painter,
    title: String,
    name: String,
    twitterId: String,
    githubId: String,
    email: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(backgroundColor),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally //中央寄せ
    ) {
        Column(
            modifier = modifier
                .padding(bottom = 150.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = logo,
                contentDescription = null,
                modifier = Modifier.size(220.dp)
            )
            Text(
                text = name,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 32.sp,
                fontFamily = FontFamily.Serif

            )
            Text(
                text = title,
                color = Color.White,
                fontSize = 24.sp,
                fontFamily = FontFamily.Serif
            )
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row() {
                Image(
                    painter = twitterIcon,
                    contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )

                Text(
                    modifier = modifier.padding(start = 10.dp),
                    text = twitterId,
                    color = Color.White,
                    fontSize = 20.sp
                )
            }

            Row() {
                Image(
                    painter = githubIcon,
                    contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )
                Text(
                    modifier = modifier.padding(start = 10.dp),
                    text = githubId,
                    color = Color.White,
                    fontSize = 20.sp
                )
            }
            Row() {
                Image(
                    painter = gmailIcon,
                    contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )
                Text(
                    modifier = modifier.padding(start = 10.dp),
                    text = email,
                    color = Color.White,
                    fontSize = 20.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NameCardAppPreview() {
    NameCardTheme {
        NameCardApp()
    }
}