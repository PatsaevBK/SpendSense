package info.javaway.spend_sense.root.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import info.javaway.spend_sense.common.ui.AppThemeProvider
import info.javaway.spend_sense.root.model.AppTab
import info.javaway.spend_sense.root.model.BottomBarItem

@Composable
fun RootBottomBar(
    modifier: Modifier,
    selectedTab: AppTab,
    clickOnTab: (AppTab) -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = AppThemeProvider.colors.surface,
                shape = RoundedCornerShape(topStart = 22.dp, topEnd = 22.dp)
            )
            .padding(8.dp)
    ) {
        BottomBarItem.entries.forEach {
            BottomBarItemView(
                isSelected = selectedTab == it.appTab,
                bottomBarItem = it,
                clickOnTab = clickOnTab
            )
        }
    }
}

@Composable
fun RowScope.BottomBarItemView(
    isSelected: Boolean,
    bottomBarItem: BottomBarItem,
    clickOnTab: (AppTab) -> Unit
) {
    val foreground =
        if (isSelected) AppThemeProvider.colors.accent else AppThemeProvider.colors.onSurface
    Column(
        modifier = Modifier
            .weight(1f)
            .padding(4.dp)
            .clickable { clickOnTab(bottomBarItem.appTab) },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = bottomBarItem.title, color = foreground)
    }
}