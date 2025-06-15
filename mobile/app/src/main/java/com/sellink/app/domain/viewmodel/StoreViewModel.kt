import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sellink.app.domain.models.Good
import com.sellink.app.domain.usecase.CategoryUseCase
import com.sellink.app.domain.usecase.GoodUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class StoreViewModel(
    private val goodUseCase: GoodUseCase = GoodUseCase(),
    private val categoryUseCase: CategoryUseCase = CategoryUseCase()
) : ViewModel() {

    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories = _categories.asStateFlow()

    private val _goods = MutableStateFlow<List<Good>>(emptyList())
    val goods = _goods.asStateFlow()

    init {
        viewModelScope.launch {
            _categories.value = categoryUseCase.getCategories()
            _goods.value = goodUseCase.getGoods()
        }
    }

    fun addGood(good: Good) {
        viewModelScope.launch {
            goodUseCase.addGood(good)
        }
    }

    fun addCategory(category: String) {
        viewModelScope.launch {
            categoryUseCase.addCategory(category)
            _categories.value = categoryUseCase.getCategories()
        }
    }
}