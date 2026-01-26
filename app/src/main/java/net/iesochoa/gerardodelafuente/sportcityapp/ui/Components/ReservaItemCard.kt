package net.iesochoa.gerardodelafuente.sportcityapp.ui.Components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SportsBasketball
import androidx.compose.material.icons.filled.SportsSoccer
import androidx.compose.material.icons.filled.SportsTennis
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import net.iesochoa.gerardodelafuente.sportcityapp.model.Reserva
import net.iesochoa.gerardodelafuente.sportcityapp.ui.theme.ColorPrimary
import net.iesochoa.gerardodelafuente.sportcityapp.ui.theme.ColorTextPrimary
import net.iesochoa.gerardodelafuente.sportcityapp.ui.theme.ColorTextSecondary
import net.iesochoa.gerardodelafuente.sportcityapp.ui.theme.TextFieldBackground

//tarjeta que mostrara la reserva con la fecha hora y nombre del cliente
@Composable
fun ReservaItemCard(
    reserva: Reserva,
    modifier: Modifier = Modifier.Companion
) {


    val sportIcon = when (reserva.deporte.lowercase()) {
        "tenis" -> Icons.Filled.SportsTennis
        "fútbol 7", "futbol 7" -> Icons.Filled.SportsSoccer
        "pádel", "padel" -> Icons.Filled.SportsTennis
        "basket" -> Icons.Filled.SportsBasketball
        else -> Icons.Filled.SportsTennis
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(110.dp),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor = ColorPrimary
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = sportIcon,
                contentDescription = "Deporte",
                tint = ColorTextPrimary,
                modifier = Modifier.size(35.dp)
            )
            Spacer(modifier = Modifier.width(15.dp))

            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = reserva.pistaNombre,
                    color = Color.White,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = "${reserva.fecha}  -  ${reserva.hora}",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = reserva.nombreCliente,
                    color = Color.White,
                    style = MaterialTheme.typography.bodySmall
                )

            }
        }

    }
}