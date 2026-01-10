package net.iesochoa.gerardodelafuente.sportcityapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import net.iesochoa.gerardodelafuente.sportcityapp.ui.theme.ColorBackground
import net.iesochoa.gerardodelafuente.sportcityapp.ui.theme.ColorError
import net.iesochoa.gerardodelafuente.sportcityapp.ui.theme.ColorPrimary
import net.iesochoa.gerardodelafuente.sportcityapp.ui.theme.ColorSuccess
import net.iesochoa.gerardodelafuente.sportcityapp.ui.theme.ColorTextPrimary
import net.iesochoa.gerardodelafuente.sportcityapp.ui.theme.ColorTextSecondary

@Composable
fun DetallePistaScreen(
    navController: NavController,
    pistaId: Int
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ColorBackground)
    ) {
        //este espacio es para la image!!!!!
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .background(ColorPrimary)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 20.dp)
        ) {
            //flichita atras
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Flecha hacia atras",
                tint = ColorTextPrimary,
                modifier = Modifier.clickable {
                    navController.popBackStack()
                }
            )
            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "Pista Tenis $pistaId",
                color = ColorTextPrimary,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(24.dp))

            //tutilo de la ddescripcion
            Text(
                text = "Descripción",
                color = ColorTextPrimary,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Pista de tenis de alta calidad, diseñada para ofrecer " +
                        "una experiencia de juego óptima tanto a nivel amateur " +
                        "como profesional. Superficie cuidada, iluminación adecuada " +
                        "y entorno tranquilo para que cada partido se disfrute al máximo.",
                color = ColorTextSecondary,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Fecha",
                color = ColorTextPrimary,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            //aqui pondre la fecha
            Text(
                text = "Fecha seleccionada: 3 de diciembre",
                color = ColorTextSecondary,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(24.dp))

            //  HORAS DISPONIBLES peroo de momento solo diseño
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                HoraChip(
                    text = "10:00",
                    backgroundColor = ColorSuccess   // verde
                )
                HoraChip(
                    text = "12:00",
                    backgroundColor = ColorPrimary   // azul
                )
                HoraChip(
                    text = "13:00",
                    backgroundColor = ColorError     // rojo
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                HoraChip(
                    text = "14:00",
                    backgroundColor = ColorPrimary
                )
                HoraChip(
                    text = "15:00",
                    backgroundColor = ColorError
                )
                HoraChip(
                    text = "16:00",
                    backgroundColor = ColorPrimary
                )
            }

            Spacer(modifier = Modifier.height(40.dp))
            Button(
                onClick = {

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp),
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = ColorPrimary
                )
            ) {
                Text(
                    text = "Reservar ahora",
                    color = ColorBackground,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}


@Composable
fun HoraChip(
    text: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .width(90.dp)
            .height(48.dp)
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(16.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = ColorBackground,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
fun detallaPreview() {
    val navController = rememberNavController()

    DetallePistaScreen(
        navController = navController,
        pistaId = 1
    )
}
