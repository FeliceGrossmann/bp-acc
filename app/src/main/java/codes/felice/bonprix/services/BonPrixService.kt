package codes.felice.bonprix.services

import codes.felice.bonprix.models.CategoryResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface BonPrixService {

    @GET("navigation")
    fun getCategories(
        @Header("x-api-key") auth: String
    ) : Call<CategoryResponse>

}