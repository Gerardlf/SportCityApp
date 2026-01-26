package net.iesochoa.gerardodelafuente.sportcityapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import net.iesochoa.gerardodelafuente.sportcityapp.ui.navigation.ScreenNavigation
import net.iesochoa.gerardodelafuente.sportcityapp.ui.theme.ColorBackground
import net.iesochoa.gerardodelafuente.sportcityapp.ui.theme.ColorPrimary
import net.iesochoa.gerardodelafuente.sportcityapp.ui.theme.ColorSecondary
import net.iesochoa.gerardodelafuente.sportcityapp.ui.theme.ColorSuccess
import net.iesochoa.gerardodelafuente.sportcityapp.ui.theme.ColorTextPrimary
// pantalla de confirmación de la reserva
@Composable
fun ConfirmacionReservaScreen(
    navController: NavController,
    deporte: String,
    pistaNombre: String,
    hora: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ColorBackground)
            .padding(horizontal = 32.dp, vertical = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        // Título confirmacion
        Text(
            text = "Confirmación",
            color = ColorTextPrimary,
            fontSize = 35.sp,
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(40.dp))

        // Círculo verde con  un ccheck
        Box(
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
                .background(ColorSuccess),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Filled.Check,
                contentDescription = "Reserva confirmada",
                tint = ColorBackground,
                modifier = Modifier.size(90.dp)
            )
        }

        Spacer(modifier = Modifier.height(50.dp))


        Text(
            text = "¡Reserva confirmada!",
            color = ColorTextPrimary,
            fontSize = 26.sp,
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(25.dp))

       //detalle de esa reserva
        Text(
            text = deporte,
            color = ColorTextPrimary,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center
        )
        Text(
            text = pistaNombre,
            color = ColorTextPrimary,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center
        )
        Text(
            text = hora,
            color = ColorTextPrimary,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(60.dp))

        // Botón que vuelve al inico
        OutlinedButton(
            onClick = {
                navController.navigate(ScreenNavigation.Home.route) {
                    popUpTo(ScreenNavigation.Home.route) {
                        inclusive = true
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            border = ButtonDefaults.outlinedButtonBorder.copy(
                width = 2.dp,
                brush = androidx.compose.ui.graphics.SolidColor(ColorSecondary)
            ),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = ColorPrimary
            )
        ) {
            Text(
                text = "Volver al inicio",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ConfirmacionReservaScreenPreview() {
    val navController = rememberNavController()

    ConfirmacionReservaScreen(
        navController = navController,
        deporte = "Tenis",
        pistaNombre = "Pista 1 - Cubierta",
        hora = "10:00"
    )
}
