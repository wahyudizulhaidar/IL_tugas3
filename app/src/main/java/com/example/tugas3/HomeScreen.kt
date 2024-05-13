package com.example.tugas3

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tugas3.component.ChatItem
import com.example.tugas3.component.OrangItem
import com.example.tugas3.data.DummyData
import com.example.tugas3.model.Chat
import com.example.tugas3.model.Orang
import com.example.tugas3.navigation.Screen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    orangg: List<Orang> = DummyData.mobileMentors,
    chatt: List<Chat> = DummyData.mobileMentees,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        item {
            LazyRow(
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = modifier
            ) {
                items(orangg, key = { it.id }) { item ->
                    OrangItem(
                        orang = item,
                        onItemClicked = { orangId ->
                            navController.navigate(Screen.Detail.route + "/$orangId")
                        }
                    )
                }
            }
        }
        items(chatt, key = { it.id }) {
            ChatItem(chat = it, modifier = Modifier.padding(horizontal = 16.dp))
        }
    }
}