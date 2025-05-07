package com.example.week09.example02.uicomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.week09.R

@Composable
fun ColumnScope.DrawerContent(modifier: Modifier = Modifier) {
    Text(
        text = "201811200 우승식", modifier = Modifier.padding(16.dp), fontSize = 20.sp
    )
    Image(
        painter = painterResource(id = R.drawable.image),
        contentDescription = "",
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    )
    Text(
        text = "intelryzen@naver.com", modifier = Modifier.padding(16.dp), fontSize = 20.sp
    )
    NavigationDrawerItem(
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = "Drawer Item 1") },
        icon = {
            Icon(
                Icons.Default.Home, contentDescription = ""
            )
        },
        onClick = {},
        selected = false
    )
    Spacer(
        modifier = Modifier.height(8.dp)
    )
    NavigationDrawerItem(
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = "Drawer Item 2") },
        onClick = {},
        selected = false
    )
}