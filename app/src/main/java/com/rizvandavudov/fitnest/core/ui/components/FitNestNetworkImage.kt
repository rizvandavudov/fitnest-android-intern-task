package com.rizvandavudov.fitnest.core.ui.components


import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import coil3.compose.AsyncImage
import coil3.request.CachePolicy
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.rizvandavudov.fitnest.R
import com.rizvandavudov.fitnest.preview.FitNestComponentPreviews
import com.rizvandavudov.fitnest.preview.FitNestPreview

@Composable
fun FitNestNetworkImage(
    imageUrl: String,
    @DrawableRes fallbackResId: Int,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop,
) {
    if (LocalInspectionMode.current) {
        Image(
            painter = painterResource(fallbackResId),
            contentDescription = contentDescription,
            modifier = modifier,
            contentScale = contentScale,
        )
    } else {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current).data(imageUrl)
                .memoryCachePolicy(CachePolicy.ENABLED).diskCachePolicy(CachePolicy.ENABLED)
                .crossfade(true).build(),
            contentDescription = contentDescription,
            modifier = modifier,
            placeholder = painterResource(fallbackResId),
            error = painterResource(fallbackResId),
            fallback = painterResource(fallbackResId),
            contentScale = contentScale,
        )
    }
}

@FitNestComponentPreviews
@Composable
private fun FitNestNetworkImagePreview() {
    FitNestPreview {
        FitNestNetworkImage(
            imageUrl = "",
            fallbackResId = R.drawable.home_light_category_fitness,
            contentDescription = "Fitness",
            modifier = Modifier.fillMaxSize(),
        )
    }
}