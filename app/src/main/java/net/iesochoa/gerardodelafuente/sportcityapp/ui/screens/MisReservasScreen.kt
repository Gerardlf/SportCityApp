package net.iesochoa.gerardodelafuente.sportcityapp.ui.screens

import android.R
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.SportsTennis
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import net.iesochoa.gerardodelafuente.sportcityapp.model.Reserva
import net.iesochoa.gerardodelafuente.sportcityapp.ui.Components.BottomNavBar
import net.iesochoa.gerardodelafuente.sportcityapp.ui.theme.ColorBackground
import net.iesochoa.gerardodelafuente.sportcityapp.ui.theme.ColorPrimary
import net.iesochoa.gerardodelafuente.sportcityapp.ui.theme.ColorSecondary
import net.iesochoa.gerardodelafuente.sportcityapp.ui.theme.ColorTextPrimary
import net.iesochoa.gerardodelafuente.sportcityapp.ui.theme.ColorTextSecondary
import net.iesochoa.gerardodelafuente.sportcityapp.ui.theme.TextFieldBackground
import net.iesochoa.gerardodelafuente.sportcityapp.ui.viewModel.ReservasViewModel

@Composable
fun MisReservasScreen(
    navController: NavController,
    viewModel: ReservasViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ColorBackground)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp, vertical = 24.dp)
            ) {
                //flecha
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Volver",
                    tint = ColorPrimary,
                    modifier = Modifier
                        .clickable { navController.popBackStack() }
                )

                Spacer(modifier = Modifier.height(24.dp))

                //titulo
                Text(
                    text = "Mis Reservas",
                    color = ColorTextPrimary,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(24.dp))

                if (uiState.reservas.isEmpty()) {
                    //si la lista esta vacia
                    Text(
                        text = "No tienes reservas",
                        color = ColorSecondary,
                        style = MaterialTheme.typography.bodyMedium
                    )
                } else {
                    //muestro listado de reservas
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(15.dp)

                    ) {
                        items(uiState.reservas) { reserva ->
                            ReservaItemCard(reserva = reserva)
                        }
                    }
                }

            }
        }
        BottomNavBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 40.dp)
        )

    }
}
//tarjeta que mostrara la reserva con la fecha hora y nombre del cliente
@Composable
fun ReservaItemCard(
    reserva: Reserva,
    modifier: Modifier= Modifier
) {
    Card(
        modifier=modifier
            .fillMaxWidth()
            .height(110.dp),
        shape = RoundedCornerShape(22.dp),
        colors= CardDefaults.cardColors(
            containerColor = TextFieldBackground
        )
    ) {
        Row(
            modifier = Modifier.fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.SportsTennis,
                contentDescription = "Deporte",
                tint = ColorTextPrimary,
                modifier = Modifier.size(35.dp)
            )
            Spacer(modifier= Modifier.height(15.dp))

            Column(
                modifier= Modifier.fillMaxWidth()
            ) {
                Text(
                    text = reserva.pistaNombre,
                    color = ColorTextPrimary,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "${reserva.fecha}  -  ${reserva.hora}",
                    color = ColorTextSecondary,
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = "${reserva.nombreCliente}",
                    color = ColorTextSecondary,
                    style = MaterialTheme.typography.bodySmall
                )
            }

        }
    }

}