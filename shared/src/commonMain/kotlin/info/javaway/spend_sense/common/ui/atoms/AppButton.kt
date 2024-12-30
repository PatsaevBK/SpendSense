package info.javaway.spend_sense.common.ui.atoms

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import info.javaway.spend_sense.common.ui.theme.AppThemeProvider

@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    title: String,
    onClick: () -> Unit,
) {
    OutlinedButton(
        modifier = modifier
            .fillMaxWidth(),
        onClick = onClick,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = AppThemeProvider.colors.onBackground,
            containerColor = AppThemeProvider.colors.background,
        ),
        border = BorderStroke(
            width = 1.dp,
            color = AppThemeProvider.colors.onSurface
        )
    ) {
        Text(
            text = title,
            color = AppThemeProvider.colors.onSurface
        )
    }
}