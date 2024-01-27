// Emre Deniz (301371047)
// Assignment 1

package com.example.mapd721_a1_emredeniz

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mapd721_a1_emredeniz.datastore.StoreUserInfo
import com.example.mapd721_a1_emredeniz.ui.theme.MAPD721A1EmreDenizTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MAPD721A1EmreDenizTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    // Define context, scope and datastore
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val dataStore = StoreUserInfo(context)

    // Retrieve saved info from Datastore
    val savedName = dataStore.getName.collectAsState(initial = "")
    val savedEmail = dataStore.getEmail.collectAsState(initial = "")
    val savedId = dataStore.getId.collectAsState(initial = "")

    // Define states for username, email and id
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var id by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {

        Spacer(modifier = Modifier.height(20.dp))

        // Username field
        OutlinedTextField(
            modifier = Modifier.padding(start = 15.dp, end = 15.dp).fillMaxWidth(),
            value = username,
            onValueChange = { username = it },
            label = { Text(text = "Username", color = Color.Black, fontSize = 14.sp) }
        )

        // Email field
        OutlinedTextField(
            modifier = Modifier.padding(start = 15.dp, end = 15.dp).fillMaxWidth(),
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email", color = Color.Black, fontSize = 14.sp) }
        )

        // ID field
        OutlinedTextField(
            modifier = Modifier.padding(start = 15.dp, end = 15.dp).fillMaxWidth(),
            value = id,
            onValueChange = { id = it },
            label = { Text(text = "ID", color = Color.Black, fontSize = 14.sp) }
        )

        Spacer(modifier = Modifier.height(20.dp))

        

        Spacer(modifier = Modifier.height(400.dp))

        // About section
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .border(BorderStroke(1.dp, Color.Black))
                .background(Color(230, 230, 230))
        ) {
            Text(
                text = "Emre Deniz" + "\n" + "301371047",
                color = Color.Black,
                fontSize = 20.sp,
                modifier = Modifier.padding(15.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MAPD721A1EmreDenizTheme {
        MainScreen()
    }
}
