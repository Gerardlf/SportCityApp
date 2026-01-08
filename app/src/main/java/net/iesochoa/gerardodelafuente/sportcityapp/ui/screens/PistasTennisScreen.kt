package net.iesochoa.gerardodelafuente.sportcityapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import net.iesochoa.gerardodelafuente.sportcityapp.ui.Components.BottomNavBar
import net.iesochoa.gerardodelafuente.sportcityapp.ui.Components.PistaCard
import net.iesochoa.gerardodelafuente.sportcityapp.ui.theme.ColorBackground
import net.iesochoa.gerardodelafuente.sportcityapp.ui.theme.ColorPrimary
import net.iesochoa.gerardodelafuente.sportcityapp.ui.theme.ColorTextPrimary
import net.iesochoa.gerardodelafuente.sportcityapp.ui.theme.ColorWarning
import net.iesochoa.gerardodelafuente.sportcityapp.ui.viewModel.PistasViewModel

@Composable
fun PistasTennisScreen(
    viewModel: PistasViewModel = viewModel()
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

                //Flecha atras
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Volver atras",
                    tint = ColorPrimary
                )
                Spacer(modifier = Modifier.height(40.dp))
                //Titulo
                Text(
                    text = "Pistas Tenis",
                    color = ColorTextPrimary,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(40.dp))

//                //Probando viewmodel
//                Text(
//                    text = "Pistas cargadas desde el viewmodel: ${uiState.pistas.size}",
//                    color = ColorTextSecondary,
//                    style = MaterialTheme.typography.bodyMedium
//                )

                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(uiState.pistas){pista ->
                        PistaCard(
                            pista = pista,
                            backgroundColor = ColorWarning,
                            icono = Icons.Filled.SportsTennis,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(90.dp)
                                .padding(vertical = 8.dp)
                        )
                    }

                }
//                //Tarjetas de cada pista
//
//                Card(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(90.dp),
//                    shape = RoundedCornerShape(16.dp),
//                    colors = CardDefaults.cardColors(
//                        containerColor = TextFieldBackground
//                    )
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .padding(16.dp),
//                        verticalArrangement = Arrangement.SpaceBetween
//                    ) {
//                        Text(
//                            text = "Pista tenis 1",
//                            color = ColorTextPrimary,
//                            style = MaterialTheme.typography.titleMedium,
//                            fontWeight = FontWeight.Bold
//                        )
//
//                        Text(
//                            text = "Cubierta · 20€/hora",
//                            color = ColorTextSecondary,
//                            style = MaterialTheme.typography.bodyMedium
//                        )
//                    }
//                }


            }
        }
        BottomNavBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PistasTenisScreenPreview() {
    PistasTennisScreen()
}