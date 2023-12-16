package com.caganbicakci.whizkid.domain.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.caganbicakci.whizkid.R
import com.caganbicakci.whizkid.domain.data.LearningClient
import com.caganbicakci.whizkid.domain.model.LearningItem
import com.caganbicakci.whizkid.domain.service.ChatResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class LearningItemViewModel @Inject constructor(private val learningClient: LearningClient) : ViewModel() {

    private val endpoint = "https://api.openai.com/v1/chat/completions"

    //private val call = chatService.getChatCompletion("Bearer $apiKey", request)

    val learningItems = listOf(
        LearningItem(id = 1, title = "Numbers", R.drawable.numbers),
        LearningItem(id = 2, title = "Characters", R.drawable.characters),
        LearningItem(id = 3, title = "Animals", R.drawable.animals),
        LearningItem(id = 4, title = "Colors", R.drawable.colors),
        LearningItem(id = 5, title = "Shapes", R.drawable.shapes),
    )

    fun getChatResult(content: String){
        learningClient.getChatResult(content).enqueue(
            object : retrofit2.Callback<ChatResponse> {
                override fun onResponse(
                    call: Call<ChatResponse>,
                    response: Response<ChatResponse>
                ) {
                    if (response.isSuccessful){
                        val choice = response.body()?.choices?.first()
                        val message = choice?.message?.content ?: "No response"
                        Log.i("ANIMAL", message)
                    }else {
                        Log.e("ERROR", "Error occured!")
                        // TODO (Handle Errors here)
                    }
                }

                override fun onFailure(call: Call<ChatResponse>, t: Throwable) {
                    t.localizedMessage?.let { Log.e("ERROR", it) }
                }

            }
        )
    }
}