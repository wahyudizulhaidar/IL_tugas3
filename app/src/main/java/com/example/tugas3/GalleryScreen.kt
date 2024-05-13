package com.example.tugas3

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tugas3.data.DummyData
import com.example.tugas3.model.Gallery
import com.example.tugas3.ui.theme.Tugas3Theme


@Composable
fun GalleryScreen(
    modifier: Modifier = Modifier,
    galeri: List<Gallery> = DummyData.galleryMeme
) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Adaptive(160.dp),
        verticalItemSpacing = 4.dp,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = modifier.fillMaxSize()
    ) {
        items(galeri, key = { it.id }) {
            Image(
                painter = painterResource(id = it.photo),
                contentDescription = it.name,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun GalleryScreenPreview() {
    Tugas3Theme {
        GalleryScreen(galeri = DummyData.galleryMeme)
    }
}