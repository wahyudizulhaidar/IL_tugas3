package com.example.tugas3.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tugas3.R
import com.example.tugas3.model.Chat
import com.example.tugas3.ui.theme.Tugas3Theme

@Composable
fun ChatItem(
    chat: Chat,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = chat.photo),
            contentDescription = chat.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .size(80.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = chat.name, style = MaterialTheme.typography.titleMedium)
            Row {
                Text(text = chat.isi, color = MaterialTheme.colorScheme.primary)
                Text(text = " - ${chat.type}")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MentorItemPreview() {
    Tugas3Theme {
        ChatItem(
            chat = Chat(
                1,
                "Nama Mentee",
                R.drawable.no_profile,
                "Batch 7",
                "Mentee Mobile"
            )
        )
    }
}
