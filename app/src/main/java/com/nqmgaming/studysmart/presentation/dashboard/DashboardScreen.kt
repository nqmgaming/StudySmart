package com.nqmgaming.studysmart.presentation.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.nqmgaming.studysmart.R
import com.nqmgaming.studysmart.domain.model.Subject
import com.nqmgaming.studysmart.presentation.components.CountCard
import com.nqmgaming.studysmart.presentation.components.SubjectCard

@Composable
fun DashboardScreen() {

    val subjects = listOf(
        Subject("Math", 10f, Subject.subjectCardColor[0]),
        Subject("Science", 15f, Subject.subjectCardColor[1]),
        Subject("History", 20f, Subject.subjectCardColor[2]),
        Subject("English", 25f, Subject.subjectCardColor[3]),
        Subject("Art", 30f, Subject.subjectCardColor[4])
    )

    Scaffold(
        topBar = {
            DashboardScreenTopBar()
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            item {
                CountCardsSection(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    subjectCounts = 5,
                    studiedHours = "10",
                    goalStudyHours = "20"
                )
            }
            item {
                SubjectCardsSection(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    subjectList = subjects
                )
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DashboardScreenTopBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.dashboard_title),
                style = MaterialTheme.typography.headlineMedium
            )
        })
}

@Composable
private fun CountCardsSection(
    modifier: Modifier = Modifier,
    subjectCounts: Int,
    studiedHours: String,
    goalStudyHours: String
) {
    Row(
        modifier = modifier
    ) {
        CountCard(
            modifier = Modifier.weight(1f),
            headingText = stringResource(id = R.string.subject_count),
            count = subjectCounts.toString()
        )
        Spacer(modifier = Modifier.width(10.dp))
        CountCard(
            modifier = Modifier.weight(1f),
            headingText = stringResource(id = R.string.studied_hours),
            count = studiedHours
        )
        Spacer(modifier = Modifier.width(10.dp))
        CountCard(
            modifier = Modifier.weight(1f),
            headingText = stringResource(id = R.string.goal_study_hours),
            count = goalStudyHours
        )
    }
}

@Composable
private fun SubjectCardsSection(
    modifier: Modifier = Modifier,
    subjectList: List<Subject>
) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(id = R.string.subject_title),
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 12.dp)
            )
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(id = R.string.add_subject)
                )
            }
        }

        if (subjectList.isEmpty()) {
            Image(
                modifier = Modifier
                    .size(120.dp)
                    .align(Alignment.CenterHorizontally),
                painter = painterResource(id = R.drawable.img_books),
                contentDescription = stringResource(
                    id = R.string.no_subjects_found
                ),
                contentScale = ContentScale.FillWidth
            )
            Text(
                text = stringResource(id = R.string.no_subjects_found),
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        LazyRow (
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(horizontal = 12.dp)
        ){
            items(subjectList) { subject ->
                SubjectCard(
                    modifier = Modifier.padding(12.dp),
                    subjectName = subject.name,
                    gradientColor = subject.colors,
                    onClick = { /*TODO*/ }
                )
            }
        }

    }

}