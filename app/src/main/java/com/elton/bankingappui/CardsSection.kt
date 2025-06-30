package com.elton.bankingappui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elton.bankingappui.data.Card
import com.elton.bankingappui.ui.theme.GreenEnd
import com.elton.bankingappui.ui.theme.GreenStart
import com.elton.bankingappui.ui.theme.OrangeEnd
import com.elton.bankingappui.ui.theme.OrangeStart
import com.elton.bankingappui.ui.theme.PurpleEnd
import com.elton.bankingappui.ui.theme.PurpleStart


val cards = listOf(


    Card(
        cardType = "Visa",
        cardNumber = "**** **** **** 1234",
        cardName = "Elton Bongue",
        balance = 100000.0,
        color = getGradient(OrangeStart, OrangeEnd),

        ),

    Card(
        cardType = "Master Card",
        cardNumber = "334 7583 7899 2223",
        cardName = "Business",
        balance = 65.641,
        color = getGradient(PurpleStart, PurpleEnd),

        ),

    Card(
        cardType = "Visa",
        cardNumber = "234 7583 7899 2223",
        cardName = "Trips",
        balance = 46.467,
        color = getGradient(GreenStart, GreenEnd),

        ),

)

fun getGradient(
    startColor: Color,
    endColor: Color,

) : Brush {

            return Brush.horizontalGradient(

                colors = listOf(startColor, endColor)

            )
    }

@Composable
fun CardsSection() {
    LazyRow {
        items(cards.size){ index ->
            CardItem(index)
        }

    }
}

@Composable
fun CardItem(index: Int) {
    val card = cards[index]
    var lastItemPaddingEnd = 0.dp
    if (index == cards.size - 1) {
        lastItemPaddingEnd = 16.dp
    }

    var image = painterResource(id = R.drawable.ic_visa_img)
    if (card.cardType == "Master Card") {
        image = painterResource(id = R.drawable.ic_mastercard_img)
    }

    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = lastItemPaddingEnd)
    ){
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(25.dp))
            .background(card.color)
            .width(250.dp)
            .height(160.dp)
            .clickable {}
            .padding(vertical = 16.dp, horizontal = 16.dp),
        verticalArrangement = Arrangement.SpaceBetween

    ) {

        Image(
            painter = image,
            contentDescription = card.cardName,
            modifier = Modifier.width(60.dp)
        )


        Text(
            text = "$ ${card.balance}",
            color = Color.White,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
            )

        Text(
            text = card.cardName,
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = card.cardNumber,
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.Light
        )

    }

   }
}