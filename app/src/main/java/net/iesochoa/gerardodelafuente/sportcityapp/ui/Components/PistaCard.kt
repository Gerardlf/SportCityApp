package net.iesochoa.gerardodelafuente.sportcityapp.ui.Components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.iesochoa.gerardodelafuente.sportcityapp.model.Pista
import net.iesochoa.gerardodelafuente.sportcityapp.ui.theme.ColorBackground


//Component para crear las tarjetas de las pistas
@Composable
fun PistaCard(
    pista: Pista,
    backgroundColor: Color,
    icono: ImageVector,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        ), onClick = onClick
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = icono,
                    contentDescription = "Icono de pista",
                    tint = ColorBackground
                )
                Spacer(modifier = Modifier.width(15.dp))

                Column {
                    Text(
                        text = pista.nombre,
                        color = ColorBackground,
                        style = MaterialTheme.typography.titleMedium,
                        fontSize = 20.sp
                    )
                    Text(
                        text = "${pista.tipo} - ${pista.precioHora} €/hora",
                        color = ColorBackground,
                        style = MaterialTheme.typography.bodySmall
                    )
                }

            }
        }
    }


}