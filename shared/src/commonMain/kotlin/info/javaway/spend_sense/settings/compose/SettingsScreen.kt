package info.javaway.spend_sense.settings.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import info.javaway.spend_sense.common.ui.theme.AppThemeProvider
import info.javaway.spend_sense.settings.SettingsViewModel
import org.jetbrains.compose.resources.stringResource
import spendsense.shared.generated.resources.Res
import spendsense.shared.generated.resources.dark_theme

@Composable
fun BoxScope.SettingScreen(
    modifier: Modifier = Modifier,
    settingsViewModel: SettingsViewModel,
) {
    val state by settingsViewModel.state.collectAsState()
    Box(modifier = modifier.size(450.dp), contentAlignment = Alignment.Center) {
        Column {
            Card(
                modifier = modifier.padding(16.dp).fillMaxWidth(),
                backgroundColor = AppThemeProvider.colors.surface,
            ) {
                Text(
                    text = state.deviceInfo,
                    color = AppThemeProvider.colors.onSurface,
                    modifier = Modifier.padding(16.dp)
                )
            }

            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .background(AppThemeProvider.colors.surface, RoundedCornerShape(16.dp))
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    stringResource(Res.string.dark_theme),
                    modifier = Modifier.weight(1f),
                    color = AppThemeProvider.colors.onSurface
                )
                Checkbox(
                    checked = state.themeIsDark,
                    onCheckedChange = { settingsViewModel.switchTheme(it) },
                    colors = CheckboxDefaults.colors(
                        checkmarkColor = AppThemeProvider.colors.accent,
                        uncheckedColor = AppThemeProvider.colors.onSurface
                    )
                )
            }
        }
    }
}