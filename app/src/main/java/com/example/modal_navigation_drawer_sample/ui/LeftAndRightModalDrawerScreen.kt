package com.example.modal_navigation_drawer_sample.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DrawerState
import androidx.compose.material.DrawerValue
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


@Composable
internal fun LeftAndRightModalDrawerScreen() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    MaterialTheme {
        Surface {
            RightSideModalDrawer(
                drawerState = drawerState,
                drawerContent = {
                    Column(Modifier.fillMaxWidth().padding(8.dp)) {
                        Text(text = "Right: drawer content")
                    }
                }
            ) {
                Content(drawerState)
            }
        }
    }
}

@Composable
private fun Content(drawerState: DrawerState) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        drawerContent = {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text("Left:  drawer content")
            }
        }
    ) {
        Column(Modifier.fillMaxWidth().padding(8.dp)) {
            val scope = rememberCoroutineScope()
            IconButton(
                onClick = {
                    scope.launch {
                        drawerState.apply {
                            if (isClosed) open() else close()
                        }
                    }
                },
            ) {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = null,
                )
            }
        }
    }
}
