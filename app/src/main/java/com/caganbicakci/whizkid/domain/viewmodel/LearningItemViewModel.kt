package com.caganbicakci.whizkid.domain.viewmodel

import androidx.lifecycle.ViewModel
import com.caganbicakci.whizkid.R
import com.caganbicakci.whizkid.domain.model.LearningItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LearningItemViewModel @Inject constructor() : ViewModel() {

    val learningItems = listOf(
        LearningItem(id = 1, title = "Numbers", R.drawable.numbers),
        LearningItem(id = 2, title = "Characters", R.drawable.characters),
        LearningItem(id = 3, title = "Animals", R.drawable.animals),
        LearningItem(id = 4, title = "Colors", R.drawable.colors),
        LearningItem(id = 5, title = "Shapes", R.drawable.shapes),
    )
}