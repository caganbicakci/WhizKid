package com.caganbicakci.whizkid.domain.data

import com.caganbicakci.whizkid.domain.service.ApiService
import com.caganbicakci.whizkid.domain.service.ChatRequest
import com.caganbicakci.whizkid.domain.service.ChatResponse
import com.caganbicakci.whizkid.domain.service.ImageRequest
import com.caganbicakci.whizkid.domain.service.ImageResponse
import com.caganbicakci.whizkid.domain.service.Message
import retrofit2.Call

private const val API_KEY = "Bearer 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"
private const val GPT_MODEL = "gpt-3.5-turbo"
private const val IMAGE_MODEL = "dall-e-2"
private const val IMAGE_SIZE = "512x512"
class LearningClientImpl(private val apiService: ApiService) : LearningClient {
    override fun getChatResult(content : String): Call<ChatResponse> {
        return apiService.getChatCompletions(
            API_KEY,
            ChatRequest(GPT_MODEL,listOf(Message("user", content)))
        )
    }

    override fun getImageResult(prompt: String): Call<ImageResponse> {
        return apiService.getImageGenerations(
            API_KEY, ImageRequest(
                model = IMAGE_MODEL,
                prompt = prompt,
                n = 1,
                size = IMAGE_SIZE
            )
        )
    }
}