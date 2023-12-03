package com.caganbicakci.whizkid.domain.recyclerview

import com.caganbicakci.whizkid.domain.model.LearningItem

interface LearningItemClickHandler {
    fun learningItemClicked(learningItem: LearningItem)
}