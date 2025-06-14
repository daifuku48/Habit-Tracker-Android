package com.danilincorporated.habit_tracker_android.navigation.navigationBottomBar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import com.danilincorporated.habit_tracker_android.extension.applyIf
import com.danilincorporated.habit_tracker_android.extension.bottomShadow
import com.danilincorporated.habit_tracker_android.extension.clickableNoRipple
import com.danilincorporated.habit_tracker_android.icon.IconPack
import com.danilincorporated.habit_tracker_android.navigation.screens.BottomBarScreen
import com.danilincorporated.habit_tracker_android.navigation.screens.BottomIcon
import com.danilincorporated.habit_tracker_android.navigation.screens.bottomBarItems
import com.danilincorporated.habit_tracker_android.theme.HabitTrackerTheme
import kotlinx.collections.immutable.ImmutableList

@Composable
internal fun HabitTrackerBottomBar(
    bottomItems: ImmutableList<BottomBarScreen>,
    selectedItem: BottomBarScreen,
    modifier: Modifier = Modifier,
    navigate: (BottomBarScreen) -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(HabitTrackerTheme.offsets.small)
            .height(
                height = HabitTrackerTheme.offsets.bottomBarHeight,
            )
            .clip(
                shape = HabitTrackerTheme.shapes.enormous
            )
            .background(
                color = HabitTrackerTheme.colors.primaryColor,
            )
            .bottomShadow(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        bottomItems.forEach { item ->
            val icon = when (item.icon) {
                BottomIcon.HOME -> IconPack.home
                BottomIcon.CALENDAR -> IconPack.calendar
                BottomIcon.ARTICLES -> IconPack.articles
                BottomIcon.PROFILE -> IconPack.profile
            }

            val tint = if (selectedItem == item) {
                HabitTrackerTheme.colors.onyx
            } else HabitTrackerTheme.colors.lightWhite

            Icon(
                imageVector = icon,
                contentDescription = item.contentDescription,
                modifier = Modifier
                    .size(
                        HabitTrackerTheme.offsets.bottomIcon,
                    )
                    .padding(HabitTrackerTheme.offsets.tiny)
                    .applyIf(selectedItem != item) {
                        clickableNoRipple(
                            onClick = {
                                navigate(item)
                            }
                        )
                    },
                tint = tint,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewHabitTrackerBottomBar() {
    HabitTrackerBottomBar(
        bottomItems = bottomBarItems,
        selectedItem = BottomBarScreen.Home,
        modifier = Modifier,
        navigate = {}
    )
}