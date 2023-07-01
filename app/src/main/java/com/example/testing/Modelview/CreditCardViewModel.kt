import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testing.Model.CreditCard
import com.example.testing.Services.CreditCardRepository
import kotlinx.coroutines.launch

class CreditCardViewModel : ViewModel() {
    private val repository = CreditCardRepository()

    private val _creditCards = MutableLiveData<List<CreditCard>>()
    val creditCards: LiveData<List<CreditCard>> = _creditCards

    fun fetchCreditCards() {
        viewModelScope.launch {
            try {
                val cards = repository.getCreditCards()
                _creditCards.value = cards
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}