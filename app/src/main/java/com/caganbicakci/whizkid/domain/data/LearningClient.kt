package com.caganbicakci.whizkid.domain.data

import com.caganbicakci.whizkid.domain.service.ChatResponse
import com.caganbicakci.whizkid.domain.service.ImageResponse
import retrofit2.Call

interface LearningClient {
    fun getChatResult(content: String) : Call<ChatResponse>
    fun getImageResult(prompt: String) : Call<ImageResponse>
}