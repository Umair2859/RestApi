import com.example.testing.Model.CreditCard
import retrofit2.http.GET

interface CreditCardService {
    @GET("/posts")
    suspend fun getCreditCards(): List<CreditCard>
}