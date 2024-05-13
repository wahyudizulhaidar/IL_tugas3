package com.example.tugas3.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tugas3.R
import com.example.tugas3.model.Orang
import com.example.tugas3.ui.theme.Tugas3Theme

@Composable
fun OrangItem(
    orang: Orang,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.clickable {
            onItemClicked(orang.id)
        }
    ) {
        Image(
            painter = painterResource(id = orang.photo),
            contentDescription = orang.name, modifier = Modifier
                .clip(CircleShape)
                .size(80.dp)
        )
        Text(
            text = orang.name,
            style = MaterialTheme.typography.titleMedium,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
            modifier = Modifier.width(80.dp),
            maxLines = 1
        )
        Text(
            text = orang.role,
            color = MaterialTheme.colorScheme.primary,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.width(80.dp),
            maxLines = 1
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MentorItemHorizontalPreview() {
    Tugas3Theme {
        OrangItem(
            orang = Orang(1, "Reza Kurniawan", "Reza", "Mobile", R.drawable.jordi),
            onItemClicked = { mentorId ->
                println("Mentor Id : $mentorId")
            }
        )
    }
}