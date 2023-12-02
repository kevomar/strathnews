package com.example.strathnews.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SingleNewsScreen(){
   Column(
       modifier = Modifier.padding(top = 40.dp)
   ) {
       Text(text = "Single")
   }
}