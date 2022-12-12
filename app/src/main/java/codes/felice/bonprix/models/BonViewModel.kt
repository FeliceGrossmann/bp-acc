package codes.felice.bonprix.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import codes.felice.bonprix.services.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BonViewModel: ViewModel() {

    lateinit var navController: NavHostController

    var title = MutableLiveData<String>()
    var _title: LiveData<String> = title

    var categories: MutableList<Category> = mutableListOf()

    var categoryListResponse: List<Category> by mutableStateOf(listOf())

    fun updateNavigation() {
        RetrofitService()
            .getBonPrixServiceCall()
            .enqueue(
                object : Callback<CategoryResponse> {

                    override fun onResponse(
                        call: Call<CategoryResponse>,
                        response: Response<CategoryResponse>
                    ) {
                        response.body()?.let {
                            categoryListResponse = it.categories
                        }
                    }

                    override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {
                        categoryListResponse = listOf(Category("Es wurden keine Elemente gefunden."))
                    }

                }
            )
    }


}