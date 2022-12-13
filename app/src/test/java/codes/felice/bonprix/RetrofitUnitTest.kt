package codes.felice.bonprix

import codes.felice.bonprix.services.RetrofitService
import kotlinx.coroutines.runBlocking
import org.junit.Test
import retrofit2.await

class RetrofitUnitTest {

    @Test
    fun service_isSuccessful() {
        runBlocking {
            val categoryResponse = RetrofitService()
                .getBonPrixServiceCall()
                .await()
            assert(categoryResponse.categories.isNotEmpty())
        }
    }

}