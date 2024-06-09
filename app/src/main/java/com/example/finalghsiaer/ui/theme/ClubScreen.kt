package com.example.finalghsiaer.ui.theme

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.finalghsiaer.model.club
import com.example.finalghsiaer.R
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Surface
import com.example.finalghsiaer.model.ClubsRepository
import androidx.compose.material3.IconButton
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.annotation.StringRes

@Composable
fun ClubList(clubs:List<club>,
             modifier: Modifier = Modifier,
             contentPadding: PaddingValues = PaddingValues(0.dp)){
    LazyColumn(contentPadding = contentPadding) {
        itemsIndexed(clubs) { index, club ->
            ClubItem(
                club = club,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp))
        }

    }

}




@Composable
fun ClubItem(club: club ,modifier: Modifier = Modifier){
    var expanded by remember { mutableStateOf(false) }
    Card (elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),modifier =modifier ){
Row (horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
    Box(modifier = Modifier
        .size(72.dp)
        .clip(RoundedCornerShape(8.dp))){
        Image(painter = painterResource(id = club.imageResourceId) ,
            contentDescription =null,
            alignment = Alignment.TopCenter,
            contentScale = ContentScale.Crop , modifier = modifier.clip(MaterialTheme.shapes.small))
    }
    Spacer(Modifier.width(16.dp))
    Text(text = stringResource(id = club.nameResourceId), style = MaterialTheme.typography.displayLarge, color = MaterialTheme.colorScheme.primary)
    Spacer(modifier = Modifier.weight(1f))
   ClubItemButton(expanded = expanded, onClick = { /*TODO*/ })

}

        Spacer(Modifier.width(16.dp))
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .sizeIn(minHeight = 72.dp)){

                Text(text = stringResource(id = club.goalResourceId) ,style = MaterialTheme.typography.displayMedium,color = MaterialTheme.colorScheme.tertiary)
        }

    }
}
@Composable
fun Goal(@StringRes dogHobby: Int,
         modifier: Modifier = Modifier){
    Column(
        modifier = modifier
    ) {
        Text(text = "Goal")
        Text(text = "Club Description")
    }

}



@Composable
private fun ClubItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier){
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = Icons.Filled.ExpandMore,
            contentDescription = stringResource(R.string.expand_button_content_description),
            tint = MaterialTheme.colorScheme.secondary

        )
    }
}




@Preview("Light Theme")
@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ClubPreview() {
    val clubTest = club(

        R.string.act,
        R.string.act_des,
        R.drawable.act
    )
    FinalGhsiaerTheme  {
        ClubItem(club=clubTest)
    }
}

@Preview("Clubs List")
@Composable
fun HeroesPreview(){
    FinalGhsiaerTheme(darkTheme = false)  {
        Surface (
            color = MaterialTheme.colorScheme.background
        ) {
            ClubList(clubs = ClubsRepository.clubs)
        }

    }
}