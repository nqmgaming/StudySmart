package com.nqmgaming.studysmart.domain.model

import androidx.compose.ui.graphics.Color
import com.nqmgaming.studysmart.presentation.theme.gradient1
import com.nqmgaming.studysmart.presentation.theme.gradient2
import com.nqmgaming.studysmart.presentation.theme.gradient3
import com.nqmgaming.studysmart.presentation.theme.gradient4
import com.nqmgaming.studysmart.presentation.theme.gradient5

data class Subject(
    val name: String,
    val goalHours: Float,
    val colors: List<Color>
) {
    companion object {
        val subjectCardColor = listOf(gradient1, gradient2, gradient3, gradient4, gradient5)
    }
}
