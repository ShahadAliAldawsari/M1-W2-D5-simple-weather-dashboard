package com.example.m1w2d5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.m1w2d5.ui.theme.M1W2D5Theme
import com.example.m1w2d5.ui.theme.mostDark

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var isDarck by remember { mutableStateOf(true) }
            M1W2D5Theme(darkTheme = isDarck) {
                WeatherDashboard(isDarck) {isDarck = !isDarck}
            }
        }
    }
}

@Composable
fun WeatherDashboard(isDark: Boolean, onThemeToggle: () -> Unit){

    Card(
        modifier = Modifier
            .fillMaxSize(),
//            .padding(16.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary),
        // in the main card I don't want rounded corners
        shape = RoundedCornerShape(0),
    ){
        //contains every thing but the top bar
        Column (
            modifier = Modifier.fillMaxWidth()
                //padding Right, Top, Left, Bottom
                .padding(16.dp)
        ){
            Spacer(Modifier.height(64.dp))

            Image(
                painter = painterResource(id = R.drawable.sun),
                contentDescription = "Sun icon",
                modifier = Modifier
                    .fillMaxWidth(),

            )
            Spacer(Modifier.height(32.dp))
            // today weather details
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 16.dp, 0.dp, 16.dp),
                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondary),

            ){
                Spacer(Modifier.height(20.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.Bottom
                ){
                    Text(text="39 C", fontSize = 55.sp)

                    Text(text="Today 35/42", fontSize = 35.sp, textAlign = TextAlign.Right,
                        modifier = Modifier.fillMaxWidth())
                }
                Spacer(Modifier.height(20.dp))
            }

            val spacer_h = 16.dp
            val spacer_w = 16.dp
            val padding_ = 4.dp
            val text_big = 33.sp
            val txt_sml =25.sp
            val img_w = 50.dp
            // weather forecast 1
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(padding_),
                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondary),
            ) {
                Row(modifier = Modifier.fillMaxWidth().padding(padding_),
                verticalAlignment = Alignment.Bottom
                ) {
                    Text(text = "25 C", fontSize = text_big)
                    Spacer(Modifier.width(spacer_w))
                    Image(
                        painter = painterResource(id = R.drawable.wind),
                        contentDescription = "wind icon",
                        modifier = Modifier.width(img_w),
                        )
                    Text(
                        text = "Tomorrow 23/31", fontSize = txt_sml, textAlign = TextAlign.Right,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            // weather forecast 2
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(padding_),
                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondary),
            ) {
                Row(modifier = Modifier.fillMaxWidth().padding(padding_),
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(text = "20 C", fontSize = text_big)
                    Spacer(Modifier.width(spacer_w))
                    Image(
                        painter = painterResource(id = R.drawable.cloudy),
                        contentDescription = "cloudy rainy icon",
                        modifier = Modifier.width(img_w),
                    )
                    Text(
                        text = "Sunday 17/23", fontSize = txt_sml, textAlign = TextAlign.Right,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            // weather forecast 3
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(padding_),
                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondary),
            ) {
                Row(modifier = Modifier.fillMaxWidth().padding(padding_),
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(text = "12 C", fontSize = text_big)
                    Spacer(Modifier.width(spacer_w))
                    Image(
                        painter = painterResource(id = R.drawable.snowflake),
                        contentDescription = "snowy icon",
                        modifier = Modifier.width(img_w),
                    )
                    Text(
                        text = "Monday 5/16", fontSize = txt_sml, textAlign = TextAlign.Right,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}