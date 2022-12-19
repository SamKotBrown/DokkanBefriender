package com.sambrown.dokkanbefrienderapp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.sambrown.dokkanbefrienderapp.R
import com.sambrown.dokkanbefrienderapp.view.destinations.FriendSearchScreenDestination
import com.sambrown.dokkanbefrienderapp.view.destinations.UserScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun HomeScreen(navigator: DestinationsNavigator) {

    val constraints = ConstraintSet {
        val searchScreenButton = createRefFor("searchScreenButton")
        val profileScreenButton = createRefFor("profileScreenButton")
        val supportMeButton = createRefFor("supportMeButton")

        val guideLineMid = createGuidelineFromTop(0.5f)
        val guideLineBottom = createGuidelineFromTop(0.8f)

        constrain(searchScreenButton) {
            top.linkTo(guideLineMid)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
            height = Dimension.value(100.dp)
        }

        constrain(profileScreenButton) {
            top.linkTo(searchScreenButton.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            height = Dimension.value(100.dp)
        }

        constrain(supportMeButton) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(guideLineBottom)
            height = Dimension.wrapContent
            width = Dimension.wrapContent
        }

        createVerticalChain(
            searchScreenButton,
            profileScreenButton,
            chainStyle = ChainStyle.Packed
        )
    }
    val buttonColor = Color(0xFF4C595A)
    val buttonBorderColor = Color(0xFF2A5EC7)

    ConstraintLayout(constraints, modifier = Modifier.fillMaxSize().background(Color.LightGray)) {

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Button(
                onClick = {
                    navigator.navigate(
                        FriendSearchScreenDestination()
                    )
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(top = 8.dp, end = 10.dp, start = 10.dp)
                    .layoutId("searchScreenButton")
                    .border(4.dp, color = buttonBorderColor),
                colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor)
            )
            {
                Text(
                    text = "Card Search",
                    fontSize = 23.sp,
                    color = Color.White
                )
            }

            Button(
                onClick = {
                    navigator.navigate(
                        UserScreenDestination()
                    )
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .layoutId("profileScreenButton")
                    .padding(top = 15.dp, end = 10.dp, start = 10.dp)
                    .border(4.dp, color = buttonBorderColor),
                colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor)
            )
            {
                Text(
                    text = "Profile",
                    color = Color.White,
                    fontSize = 23.sp
                )
            }

            Button(
                onClick = {
                    //Opens some kind of billing / support links thingy
                },
                modifier = Modifier
                    .layoutId("supportMeButton")
                    .padding(top = 15.dp)
                    .border(4.dp, color = buttonBorderColor),
                colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
            )
            {
                Image(painter = painterResource(id = R.drawable.two_coins_icon), contentDescription = "2 coins icon")
            }
        }
    }
}