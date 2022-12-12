package codes.felice.bonprix.services

import codes.felice.bonprix.models.Category
import codes.felice.bonprix.models.CategoryResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService() {

    private val apiUrl = "https://codechallenge.mobilelab.io/v1/bonprix/"
    private val apiKey = "N8Nx0OwOvo1iuN2ZkFHZlyVKBVgoIcy4tUHMppO5"

    private val retrofit = Retrofit.Builder()
        .baseUrl(apiUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getBonPrixServiceCall(): Call<CategoryResponse> {
        val bonPrixService = retrofit.create(BonPrixService::class.java)

        return bonPrixService
            .getCategories(apiKey)

    }

}