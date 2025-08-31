package com.example.interfaceintagram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstagramUI()
        }
    }
}

@Composable
fun InstagramUI() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(padding)
        ) {
            // Top Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Instagram", fontWeight = FontWeight.Bold, fontSize = 22.sp)
                Row {
                    IconButton(onClick = {
                        scope.launch { snackbarHostState.showSnackbar("Buscar clickeado") }
                    }) {
                        Icon(Icons.Filled.Search, contentDescription = "Search")
                    }
                    IconButton(onClick = {
                        scope.launch { snackbarHostState.showSnackbar("Compartir clickeado") }
                    }) {
                        Icon(Icons.Filled.Share, contentDescription = "Share")
                    }
                }
            }

            // Stories
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                repeat(5) { index ->
                    Box(
                        modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape)
                            .background(Color.LightGray)
                            .clickable {
                                scope.launch { snackbarHostState.showSnackbar("Historia $index clickeada") }
                            }
                    )
                }
            }

            // Post
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .background(Color(0xFFEAEAEA))
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row {
                        IconButton(onClick = {
                            scope.launch { snackbarHostState.showSnackbar("Me gusta clickeado") }
                        }) {
                            Icon(Icons.Filled.Favorite, contentDescription = "Like")
                        }
                        IconButton(onClick = {
                            scope.launch { snackbarHostState.showSnackbar("Comentar clickeado") }
                        }) {
                            Icon(Icons.Filled.Comment, contentDescription = "Comment")
                        }
                        IconButton(onClick = {
                            scope.launch { snackbarHostState.showSnackbar("Compartir clickeado") }
                        }) {
                            Icon(Icons.Filled.Share, contentDescription = "Share")
                        }
                    }
                    IconButton(onClick = {
                        scope.launch { snackbarHostState.showSnackbar("Guardar clickeado") }
                    }) {
                        Icon(Icons.Filled.Bookmark, contentDescription = "Save")
                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { scope.launch { snackbarHostState.showSnackbar("Inicio clickeado") } }) {
                    Icon(Icons.Filled.Home, contentDescription = "Home")
                }
                IconButton(onClick = { scope.launch { snackbarHostState.showSnackbar("Buscar clickeado") } }) {
                    Icon(Icons.Filled.Search, contentDescription = "Search")
                }
                IconButton(onClick = { scope.launch { snackbarHostState.showSnackbar("Agregar clickeado") } }) {
                    Icon(Icons.Filled.Add, contentDescription = "Add")
                }
                IconButton(onClick = { scope.launch { snackbarHostState.showSnackbar("Reels clickeado") } }) {
                    Icon(Icons.Filled.VideoLibrary, contentDescription = "Reels")
                }
                IconButton(onClick = { scope.launch { snackbarHostState.showSnackbar("Perfil clickeado") } }) {
                    Icon(Icons.Filled.Person, contentDescription = "Profile")
                }
            }
        }
    }
}
