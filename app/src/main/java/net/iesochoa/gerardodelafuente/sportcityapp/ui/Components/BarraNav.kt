package net.iesochoa.gerardodelafuente.sportcityapp.ui.Components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.Help
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.iesochoa.gerardodelafuente.sportcityapp.ui.theme.ColorBackground
import net.iesochoa.gerardodelafuente.sportcityapp.ui.theme.ColorPrimary
import net.iesochoa.gerardodelafuente.sportcityapp.ui.theme.ColorTextSecondary

@Composable
fun NavegItem(
    icon: ImageVector,
    label: String,
    selected: Boolean
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            modifier = Modifier.size(24.dp),
            tint = if (selected) ColorPrimary else ColorTextSecondary
        )
        Text(
            text = label,
            fontSize = 12.sp,
            color = if (selected) ColorPrimary else ColorTextSecondary
        )
    }
}
@Composable
fun BottomNavBar(modifier: Modifier) {
    Surface(
        tonalElevation = 8.dp,
        color = ColorBackground,
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            NavegItem(
                icon = Icons.Filled.Home,
                label = "Inicio",
                selected = true   // de momento "Inicio" seleccionado fijo
            )
            NavegItem(
                icon = Icons.Filled.Event,
                label = "Reservas",
                selected = false
            )
            NavegItem(
                icon = Icons.Filled.Person,
                label = "Perfil",
                selected = false
            )
            NavegItem(
                icon = Icons.Filled.Help,
                label = "Ayuda",
                selected = false
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavBarPreview() {
    BottomNavBar(modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 16.dp))
}