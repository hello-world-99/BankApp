package com.test.project1.homepage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.test.project1.R
import com.test.project1.data.Card
import com.test.project1.ui.theme.BlueEnd
import com.test.project1.ui.theme.BlueStart
import com.test.project1.ui.theme.OrangeEnd
import com.test.project1.ui.theme.OrangeStart
import com.test.project1.ui.theme.PurpleEnd
import com.test.project1.ui.theme.PurpleStart

val cards = listOf(
    Card(
        cardType = "VISA",
        cardNumber = "1234 5678 1234 5678",
        cardName = "Business",
        balance = 55.33,
        color = getGradient(startColor = PurpleStart, endColor = PurpleEnd)
    ),
    Card(
        cardType = "MASTER CARD",
        cardNumber = "1357 2468 1928 3746",
        cardName = "Savings",
        balance = 125.450,
        color = getGradient(startColor = BlueStart, endColor = BlueEnd)
    ),
    Card(
        cardType = "VISA",
        cardNumber = "2222 4444 6666 1111",
        cardName = "School",
        balance = 15.445,
        color = getGradient(startColor = OrangeStart, endColor = OrangeEnd)
    ),
    Card(
        cardType = "MASTER CARD",
        cardNumber = "1111 0101 1100 0001",
        cardName = "Trips",
        balance = 77.000,
        color = getGradient(startColor = PurpleStart, endColor = PurpleEnd)
    )

)


fun  getGradient(startColor:Color,endColor:Color):Brush{
    return  Brush.horizontalGradient(colors = listOf(startColor,endColor))
}

@Preview
@Composable
fun CardsSec(){
    LazyRow {
        items(cards.size){ index->
            CardItem(index)
        }
    }
}



@Composable
fun CardItem(index:Int){
    val  card= cards[index]
    var  lastItemPadding=0.dp
    if(index== cards.size-1){
        lastItemPadding=16.dp
    }
    var image = painterResource(id = R.drawable.ic_visa)
    if (card.cardType=="MASTER CARD"){
        image = painterResource(id = R.drawable.ic_mastercard)
    }
    Box (modifier = Modifier.padding(start =16.dp, end = lastItemPadding)){
        Column(modifier = Modifier
            .clip(RoundedCornerShape(25.dp))
            .background(card.color)
            .width(250.dp)
            .height(160.dp)
            .clickable { }
            .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
                Image(
                    painter = image,
                    contentDescription = card.cardName,
                    modifier = Modifier.width(60.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = card.cardName,
                    color = Color.White,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold
                )
            Text(
                text = "$ ${ card.balance }",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = card.cardNumber,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

        }
    }
}