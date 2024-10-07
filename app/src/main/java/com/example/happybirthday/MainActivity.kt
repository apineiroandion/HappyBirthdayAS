package com.example.happybirthday

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    GreetingText(message = "Happy Birthday Sam!", from = "From Emma")
                    GreetingImage(message = "Happy Birthday Damian!", from = "From Anxo")
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String,from: String, modifier: Modifier = Modifier){
    //el remember es para que no se pierda el valor de la variable
    //mutableStateOf es para que el valor de la variable pueda cambiar
    var counter by remember { mutableStateOf(0) }
    var name = remember { mutableStateOf("") }
    Column (
        verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(8.dp)
    ) {
        Text(
            text = message,
            fontSize = 90.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center,
        )
        Text(
            text = from,
            fontSize = 36.sp,
            fontStyle = FontStyle.Italic,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.End)

        )
        Button(
            onClick = { counter++
                Log.d("MainActivity", "Button clicked!")
                      },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(300.dp, 100.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue, // Color de fondo del n botón
                contentColor = Color.White,   // Color del texto del botón

            )
            ) {
            Text(
                text = "Click me! CLICS: $counter",
                fontSize = 24.sp,
            )
            }

    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.fondoapp)
    Box (modifier){
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F,
            modifier = Modifier
                .fillMaxSize(),
        )
        GreetingText(message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
        )
    }
}


@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
//    HappyBirthdayTheme {
//        GreetingText(message = "Happy Birthday! Sam", from = "From: Anxo")
//    }
    GreetingImage(message = "Happy Birthday Sam!", from = "From Emma")
}