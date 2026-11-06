package com.example.kiosk

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * 음료 아이템 데이터 클래스
 */
data class BeverageItem(
    val id: Long = 0,
    val name: String,
    val price: String? = null,
    val imageResId: Int? = null
)

/**
 * 기본 예시 음료 목록
 */
val defaultBeverages = listOf(
    BeverageItem(1, "아메리카노", "4,000원"),
    BeverageItem(2, "카페라떼", "4,500원"),
    BeverageItem(3, "바닐라라떼", "5,000원"),
    BeverageItem(4, "카푸치노", "4,500원"),
    BeverageItem(5, "녹차라떼", "5,200원"),
    BeverageItem(6, "자몽에이드", "5,500원"),
    BeverageItem(7, "초코라떼", "5,000원"),
    BeverageItem(8, "복숭아 아이스티", "3,800원")
)

/**
 * 정사각형 이미지와 하단 텍스트를 포함하는 음료 그리드 컴포저블
 */
@Composable
fun BeverageVerticalGrid(
    modifier: Modifier = Modifier,
    beverages: List<BeverageItem> = defaultBeverages,
    columns: GridCells = GridCells.Adaptive(minSize = 140.dp),
    state: LazyGridState = rememberLazyGridState(),
    contentPadding: PaddingValues = PaddingValues(16.dp),
    onItemClick: (BeverageItem) -> Unit = {}
) {
    LazyVerticalGrid(
        columns = columns,
        modifier = modifier,
        state = state,
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(beverages, key = { it.id }) { item ->
            BeverageItemCard(
                item = item,
                onClick = { onItemClick(item) }
            )
        }
    }
}

/**
 * 정사각형 이미지와 하단 텍스트로 구성된 음료 카드
 */
@Composable
fun BeverageItemCard(
    item: BeverageItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 1:1 비율의 정사각형 이미지 영역
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                if (item.imageResId != null) {
                    Image(
                        painter = painterResource(id = item.imageResId),
                        contentDescription = item.name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                } else {
                    Text(
                        text = item.name.take(1),
                        style = MaterialTheme.typography.headlineLarge,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            // 하단 텍스트 영역
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = item.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                if (!item.price.isNullOrEmpty()) {
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = item.price,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BeverageVerticalGridPreview() {
    MaterialTheme {
        BeverageVerticalGrid()
    }
}
