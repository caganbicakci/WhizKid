package com.caganbicakci.whizkid.domain.service

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {
    @Headers("Content-Type: application/json")
    @POST("v1/chat/completions")
    fun getChatCompletions(
        @Header("Authorization") apiKey: String,
        @Body request: ChatRequest
    ): Call<ChatResponse>

    @Headers("Content-Type: application/json")
    @POST("v1/images/generations")
    fun getImageGenerations(
        @Header("Authorization") apiKey: String,
        @Body request: ImageRequest
    ): Call<ImageResponse>
}

//Chat Completions
data class ChatRequest(val model: String, val messages: List<Message>)
data class Message(val role: String, val content: String)
data class ChatResponse(val id: String, val choices: List<Choice>)
data class Choice(val message: Message)

//Image Generations
data class ImageRequest(val model: String, val prompt: String, val n: Int, val size: String)
data class ImageResponse(val created : String, val data: List<ImageData>)
data class ImageData(val url: String)
