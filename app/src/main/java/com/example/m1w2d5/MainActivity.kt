package com.example.m1w2d5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.FlowRowScopeInstance.align
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.m1w2d5.ui.theme.M1W2D5Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var isDarkTheme by remember { mutableStateOf(true) }
            M1W2D5Theme(darkTheme = isDarkTheme){


                Scaffold (
                    topBar = {
                        TopBar(modifier = Modifier, isDarkTheme){isDarkTheme = !isDarkTheme}
                    }
                ){
                    paddingValues -> WeatherDashboard(modifier= Modifier.padding(paddingValues))

                }

            }
        }
    }
}

//i'm using the following line to deal with "This material API is experimental..." error
@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun TopBar(modifier: Modifier=Modifier, isDarkTheme: Boolean, onThemeToggle: () -> Unit){
    TopAppBar(
        modifier = Modifier.fillMaxWidth()
            .padding(16.dp),
        title = {
            val context = LocalContext.current
            Text(
                text = context.getString(R.string.title),
//                fontSize = 20.sp,// no need when ues style
//                color = MaterialTheme.colorScheme.onBackground// it does not workkk!!
                style = MaterialTheme.typography.headlineLarge
            )

        },
        // top bar color
        colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.background),

        // nav icon
        navigationIcon = {
            Icon(
                imageVector = Icons.Rounded.Menu,
                contentDescription = "Menu icon",
                modifier = Modifier.width(40.dp)
                    .padding(start = 8.dp, end = 8.dp),
                tint = MaterialTheme.colorScheme.onBackground
            )
        },
        actions = {
            // location icon
            Icon(
                imageVector = Icons.Rounded.LocationOn,
                contentDescription = "Location icon",
                modifier = Modifier,
                tint = MaterialTheme.colorScheme.onBackground
            )
            Spacer(Modifier.width(8.dp))

            // dark light themes button
            Button(
                onClick = onThemeToggle,
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                modifier = Modifier,
            ) {
                // dark light themes icon
                Icon(
                    painter = painterResource(id = R.drawable.sunmoon2),
                    contentDescription = "sun & moon icon",
                    modifier = Modifier
                        .width(25.dp)
                        .height(25.dp),
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    )
}

@Preview
@Composable
fun WeatherDashboard(modifier: Modifier=Modifier){
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxSize(),
//            .padding(16.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.background),
        // in the main card I don't want rounded corners
        shape = RoundedCornerShape(0),

    ){


        //contains every thing but the top bar
        Column (
            modifier = Modifier.fillMaxWidth()
                //padding Right, Top, Left, Bottom
                .padding(16.dp)
        ){
            Spacer(Modifier.height(150.dp))

            Image(
                painter = painterResource(id = R.drawable.sun),
                contentDescription = "Sun icon",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                Alignment.Center

            )
            Spacer(Modifier.height(20.dp))
            // today weather details
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
//                    .padding(16.dp),
                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface),


            ){
                Spacer(Modifier.height(20.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.Bottom
                ){

                    Text(text=context.getString(R.string.today_degree), fontSize = 60.sp)

                    Text(text=context.getString(R.string.today), /*fontSize = 35.sp,*/ textAlign = TextAlign.End,
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier.fillMaxWidth())
                }
                Spacer(Modifier.height(20.dp))
            }
            Spacer(Modifier.height(40.dp))
            // I use vals for easier and faster experiments
            val spacer_h = 16.dp
            val spacer_w = 16.dp
            val padding_ = 4.dp
            val img_w = 50.dp

            // weather forecast day1
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(padding_),
                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface),
            ) {
                Row(modifier = Modifier.fillMaxWidth().padding(padding_),
                verticalAlignment = Alignment.Bottom
                ) {
                    Text(text = context.getString(R.string.deg_1), /*fontSize = text_big,*/ style = MaterialTheme.typography.headlineMedium)
                    Spacer(Modifier.width(spacer_w))
                    Image(
                        painter = painterResource(id = R.drawable.sun),
                        contentDescription = "wind icon",
                        modifier = Modifier.width(img_w),
                        )
                    Text(
                        text =context.getString(R.string.day_1), /*fontSize = txt_sml,*/ textAlign = TextAlign.End,
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
            Spacer(Modifier.height(spacer_h))

            // weather forecast day2
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(padding_),
                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface),
            ) {
                Row(modifier = Modifier.fillMaxWidth().padding(padding_),
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(text = context.getString(R.string.deg_2), /*fontSize = text_big,*/style = MaterialTheme.typography.headlineMedium)
                    Spacer(Modifier.width(spacer_w))
                    Image(
                        painter = painterResource(id = R.drawable.wind),
                        contentDescription = "cloudy rainy icon",
                        modifier = Modifier.width(img_w),

                    )
                    Text(
                        text = context.getString(R.string.day_2), /*fontSize = txt_sml, */textAlign = TextAlign.End,
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
            Spacer(Modifier.height(spacer_h))

            // weather forecast day3
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(padding_),
                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface),
            ) {
                Row(modifier = Modifier.fillMaxWidth().padding(padding_),
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(text = context.getString(R.string.deg_3), /*fontSize = text_big,*/style = MaterialTheme.typography.headlineMedium)
                    Spacer(Modifier.width(spacer_w))
                    Image(
                        painter = painterResource(id = R.drawable.snowflake),
                        contentDescription = "snowy icon",
                        modifier = Modifier.width(img_w),
                    )
                    Text(
                        text = context.getString(R.string.day_3), /*fontSize = txt_sml,*/ textAlign = TextAlign.End,
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}