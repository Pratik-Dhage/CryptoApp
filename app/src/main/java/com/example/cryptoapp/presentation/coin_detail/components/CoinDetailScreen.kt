package com.example.cryptoapp.presentation.coin_detail.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.cryptoapp.presentation.Screen
import com.example.cryptoapp.presentation.coin_detail.CoinDetailViewModel
import com.example.cryptoapp.presentation.coin_list.CoinListViewModel
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun CoinDetailScreen(
    viewModel: CoinDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {

        state.coin?.let { coin ->
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(20.dp)
            ) {
                item {
                    Row(
                        modifier = Modifier,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {

                        Text(
                            text = " ${coin.rank} ${coin.name} (${coin.symbol})",
                            style = MaterialTheme.typography.h2,
                            modifier = Modifier.weight(8f),
                            color = Color.White
                        )

                        Text(
                            text = if (coin.isActive) "Active" else "InActive",
                            color = if (coin.isActive) Color.Green else Color.Red,
                            fontStyle = FontStyle.Italic,
                            textAlign = TextAlign.End,
                            modifier = Modifier
                                .align(CenterVertically)
                                .weight(2f)
                        )

                        Spacer(modifier = Modifier.height(15.dp)) // for Space

                        //Description
                        Text(
                            text = coin.description,
                            style = MaterialTheme.typography.body2,
                            color = Color.White
                        )

                        Spacer(modifier = Modifier.height(15.dp)) // for Space

                        Text(
                            text = "TAGS",
                            style = MaterialTheme.typography.h4,
                            color = Color.White
                        )

                        Spacer(modifier = Modifier.height(15.dp)) // for Space

                        FlowRow(
                            mainAxisSpacing = 10.dp,
                            crossAxisSpacing = 10.dp,
                            modifier = Modifier.fillMaxWidth()
                        ) {

                            coin.tags.forEach { tag ->
                                CoinTag(tag = tag)
                            }
                        }

                        Spacer(modifier = Modifier.height(15.dp)) // for Space

                        Text(
                            text = "TEAM MEMBERS",
                            style = MaterialTheme.typography.h3,
                            color = Color.White
                        )

                        Spacer(modifier = Modifier.height(15.dp)) // for Space
                    }
                }
                items(
                    coin.team
                ) { teamMember ->
                    TeamListItem(
                        teamMember = teamMember,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    )
                    Divider() // Divider Line

                }
            }
        }


        //if Coin List is Empty
        if (state.error.isNotBlank()) {

            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
                    .padding(horizontal = 20.dp)
            )
        }
        // if Loading for Data
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center), color = Color.Green)
        }
    }

}