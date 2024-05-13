package com.example.tugas3

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugas3.model.AboutMe

@Composable
fun AboutScreen(
    aboutMe: AboutMe = AboutMe(),
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                item {
                    Image(
                        painter = painterResource(id = R.drawable.photosaya),
                        contentDescription = "Foto Profil",
                        modifier = Modifier.size(128.dp)
                    )
                    Column(modifier = Modifier.padding(8.dp)) {
                        Text(
                            text = aboutMe.namaLengkap,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Text(
                            text = aboutMe.namaPanggilan,
                            fontSize = 12.sp,
                            color = Color.Black
                        )
                    }
                }
            }
        }
        item {
            Text(
                text = "Tentang Saya",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
        item {
            Column {
                Text(
                    text = "Riwayat Pendidikan",
                    fontSize = 12.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Column(
                    Modifier
                        .padding(start = 10.dp)
                ) {
                    Text(
                        text = "SD : SDN 168 Bassaran",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Text(
                        text = "SMP : SDN 168 Bassaran",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Text(
                        text = "SMA: MAN Enrekang",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailMentorContentPreview() {
    AboutScreen(aboutMe = AboutMe())
}