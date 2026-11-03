package com.example.kiosk

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.PrimaryScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * 내부 상태를 관리하는 CategoryTabRow 컴포저블
 */
@Composable
fun CategoryTabRow(
    modifier: Modifier = Modifier,
    categories: List<String> = listOf("전체", "추천", "커피", "음료", "디저트", "세트메뉴", "신메뉴"),
    initialTabIndex: Int = 0,
    onCategorySelected: (index: Int, category: String) -> Unit = { _, _ -> }
) {
    var selectedTabIndex by remember { mutableIntStateOf(initialTabIndex) }

    CategoryTabRowContent(
        modifier = modifier,
        categories = categories,
        selectedTabIndex = selectedTabIndex,
        onCategorySelected = { index ->
            selectedTabIndex = index
            onCategorySelected(index, categories[index])
        }
    )
}

/**
 * 상태 호이스팅(State Hoisting)을 지원하는 Stateless CategoryTabRow 컴포저블
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryTabRowContent(
    categories: List<String>,
    selectedTabIndex: Int,
    onCategorySelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    PrimaryScrollableTabRow(
        selectedTabIndex = selectedTabIndex,
        edgePadding = 16.dp,
        modifier = modifier
    ) {
        categories.forEachIndexed { index, category ->
            Tab(
                selected = selectedTabIndex == index,
                onClick = { onCategorySelected(index) },
                text = { Text(text = category) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryTabRowPreview() {
    CategoryTabRow()
}