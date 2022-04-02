package com.example.modal_navigation_drawer_sample.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DrawerState
import androidx.compose.material.DrawerValue
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalDrawer
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

@Composable
internal fun RightSideModalDrawer(
    drawerState: DrawerState,
    drawerContent: @Composable ColumnScope.() -> Unit,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        ModalDrawer(
            drawerContent = {
                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
                    drawerContent()
                }
            },
            drawerState = drawerState,
            content = {
                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
                    content()
                }
            }
        )
    }
}

@Preview
@Composable
fun DrawerPreview() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    MaterialTheme {
        Surface {
            RightSideModalDrawer(
                drawerState = drawerState,
                drawerContent = {
                    Column(
                        Modifier.fillMaxWidth().padding(8.dp)) {
                        Text(text = "drawer content")
                    }
                }
            ) {
                Column(
                    Modifier.fillMaxWidth().padding(8.dp)) {
                    Text(text = "main content")
                }
            }
        }
    }
}