package com.example.pdm123f.secondpartial.onboarding

import androidx.annotation.FloatRange
import androidx.annotation.IntRange
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pdm123f.R
import com.example.pdm123f.ui.theme.Red200
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun OnboardingView() {
    val items = ArrayList<OnBoardingData>()

    items.add(
        OnBoardingData(
            "Glad to see you! You'll discover new amazing Car Audio products"
        )
    )

    items.add(
        OnBoardingData(
            "With us, you can buy whatever Car Audio component or accesory you need",
        )
    )

    items.add(
        OnBoardingData(
            "Don’t hesitate to ask for help! Our support team is available 24/7",
        )
    )
    val pagerState = rememberPagerState(
        pageCount = items.size,
        initialOffscreenLimit = 2,
        infiniteLoop = false,
        initialPage = 0
    )
    val backgroundImage =
        painterResource(id = R.drawable.onboardscreen) // Replace with your background image
    Box {

    }
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Image(
            painter = backgroundImage,
            contentDescription = null, // Provide a content description if needed
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )


        OnBoardingPager(
            item = items,
            pagerState = pagerState,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@ExperimentalPagerApi
@Composable
fun OnBoardingPager(
    item: List<OnBoardingData>,
    pagerState: PagerState,
    modifier: Modifier = Modifier,

    ) {
    Box(modifier = modifier) {
        Spacer(modifier = Modifier.height(790.dp))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 40.dp)
        ) {
            HorizontalPager(
                state = pagerState
            ) { page ->
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.Start // Align the content to the start
                ) {
                    Spacer(modifier = Modifier.height(530.dp)) // Add spacer for spacing

                    Text(
                        text = item[page].title,
                        modifier = Modifier.padding(top = 50.dp),
                        color = Color.White,
                        style = MaterialTheme.typography.displayLarge // Adjust font size
                    )


                }
            }

            PagerIndicator(item.size, pagerState.currentPage)
        }
        Box(modifier = Modifier.align(Alignment.BottomCenter)) {
            BottomSection(pagerState.currentPage, pagerState)
        }
    }
}

@ExperimentalPagerApi
@Composable
fun rememberPagerState(
    @IntRange(from = 0) pageCount: Int,
    @IntRange(from = 0) initialPage: Int = 0,
    @FloatRange(from = 0.0, to = 1.0) initialPageOffset: Float = 0f,
    @IntRange(from = 1) initialOffscreenLimit: Int = 1,
    infiniteLoop: Boolean = false
): PagerState = rememberSaveable(
    saver = PagerState.Saver
) {
    PagerState(
        pageCount = pageCount,
        currentPage = initialPage,
        currentPageOffset = initialPageOffset,
        offscreenLimit = initialOffscreenLimit,
        infiniteLoop = infiniteLoop
    )
}

@Composable
fun PagerIndicator(
    size: Int,
    currentPage: Int
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(top = 60.dp)
    ) {
        repeat(size) {
            Indicator(isSelected = it == currentPage)
        }
    }
}

@Composable
fun Indicator(isSelected: Boolean) {
    val width = animateDpAsState(targetValue = if (isSelected) 25.dp else 10.dp)

    Box(
        modifier = Modifier
            .padding(1.dp)
            .height(10.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(
                if (isSelected) Color.White else Color.White.copy(alpha = 0.5f)
            )
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BottomSection(currentPager: Int, pagerState: PagerState) {
    Row(
        modifier = Modifier
            .padding(bottom = 20.dp)
            .fillMaxWidth(),
        horizontalArrangement = if (currentPager != 2) Arrangement.SpaceBetween else Arrangement.Center
    ) {
        if (currentPager == 2) {
            OutlinedButton(
                onClick = { },
                shape = RoundedCornerShape(50),
            ) {
                Text(
                    text = "Get Started",
                    modifier = Modifier
                        .padding(vertical = 8.dp, horizontal = 40.dp),
                    color = Color.White,
                )
            }
        } else {
            SkipNextButton(text = "Skip", modifier = Modifier.padding(start = 20.dp), pagerState)
            SkipNextButton(text = "Next", modifier = Modifier.padding(end = 20.dp), pagerState)
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun SkipNextButton(text: String, modifier: Modifier, pagerState: PagerState) {
    val coroutineScope = rememberCoroutineScope()

    Text(
        text = text,
        color = Color.White,
        modifier = modifier.clickable {
            if (text == "Skip") {
                // Cambiar a la última página al hacer clic en "Skip"
                val lastPage = pagerState.pageCount - 1
                if (lastPage >= 0) {
                    coroutineScope.launch {
                        pagerState.scrollToPage(lastPage)
                    }
                }
            } else if (text == "Next") {
                // Cambiar a la siguiente página al hacer clic en "Next"
                val nextPage = pagerState.currentPage + 1
                if (nextPage < pagerState.pageCount) {
                    coroutineScope.launch {
                        pagerState.scrollToPage(nextPage)
                    }
                }
            }
        },
        fontSize = 18.sp,
        style = MaterialTheme.typography.headlineLarge,
        fontWeight = FontWeight.Medium
    )
}










