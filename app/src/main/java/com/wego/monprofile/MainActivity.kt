package com.wego.monprofile

import android.graphics.fonts.Font
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wego.monprofile.ui.theme.MonProfileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MonProfileTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    BgImage(id = R.drawable.background, md = Modifier.fillMaxSize(), contentSacle = ContentScale.Crop)
    Box(
        contentAlignment = Alignment.TopStart,
        modifier = Modifier.fillMaxWidth()
            .background(color = Color.Transparent)
    ) {
        Column(modifier = Modifier.fillMaxSize()
            .padding(WindowInsets.statusBars.asPaddingValues())
        ) {
            BgImage(id = R.drawable.cover, md = Modifier.fillMaxWidth().height(150.dp), contentSacle = ContentScale.Crop)
            Spacer(modifier = Modifier.height(20.dp).fillMaxSize())
            Column(modifier = Modifier.padding(horizontal = 10.dp)) {
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom
                ) {
                    Surface(modifier = Modifier.size(120.dp)
                        .padding(5.dp),
                        shape = CircleShape,
                        color = Color.White,
                        shadowElevation = 2.dp
                    ) {
                        BgImage(
                            id = R.drawable.profile,
                            md = Modifier.fillMaxSize()
                                .padding(4.dp)
                                .clip(CircleShape)
                            , contentSacle = ContentScale.Crop)
                    }
                    Text(
                        text = stringResource(R.string.name),
                        color = Color.Black,
                        fontSize = 21.sp,
                        fontWeight = FontWeight.W600,
                    )
                }
                Spacer(modifier = Modifier.height(20.dp).fillMaxSize())
                HorizontalDivider(thickness = 2.dp, color = Color.White)
                Spacer(modifier = Modifier.height(20.dp).fillMaxSize())
                Text(
                    text = stringResource(R.string.description),
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W600,
                    color = Color.White,
                    fontStyle = FontStyle.Italic
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MonProfileTheme {
        Greeting("Android")
    }
}

@Composable
fun BgImage(id: Int, md: Modifier, contentSacle: ContentScale) {
    Image(
        painter = painterResource(id  = id), modifier = md,
        contentDescription = stringResource(id = R.string.background),
        contentScale = contentSacle
    )
}