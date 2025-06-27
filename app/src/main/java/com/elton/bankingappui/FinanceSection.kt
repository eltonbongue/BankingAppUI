package com.elton.bankingappui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MonetizationOn
import androidx.compose.material.icons.rounded.StarHalf
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elton.bankingappui.data.Finance
import com.elton.bankingappui.ui.theme.BlueStart
import com.elton.bankingappui.ui.theme.GreenStart
import com.elton.bankingappui.ui.theme.OrangeStart
import com.elton.bankingappui.ui.theme.PurpleStart

val financeList = listOf(
    Finance (
        icon = Icons.Rounded.StarHalf,
        name = "My\nbusiness",
        background = OrangeStart

    ),

    Finance (

        icon = Icons.Rounded.Wallet,
        name = "My\nWallet",
        background = BlueStart
    ),

    Finance (
        icon = Icons.Rounded.StarHalf,
        name = "My\nAnalytics",
        background = PurpleStart
    ),

    Finance (
        icon = Icons.Rounded.MonetizationOn,
        name = "My\nTransactions",
        background = GreenStart
    ),


)

@Preview
@Composable
fun FinanceSection() {

    Column {
           Text(
            text = "Finance",
            fontSize = 25.sp,
            modifier = Modifier.padding(16.dp)
           )

        LazyRow {
            items(financeList.size) {
                FinanceItem(it)
            }
        }
    }

}

@Composable
fun FinanceItem(index: Int) {

    val finance = financeList[index]
    var lastPaddingEnd = 0.dp
    if(index == financeList.size - 1){
        lastPaddingEnd = 16.dp
    }



}