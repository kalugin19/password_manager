package com.kalugin19.passstore.view.add

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kalugin19.passstore.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddRecordViewModel @Inject constructor(
    private val recordsRepository: RecordsRepository
) : ViewModel() {

    val loginValidation = MutableLiveData("")
    val passwordValidation = MutableLiveData("")
    val loginTextField = MutableLiveData("")
    val passwordTextField = MutableLiveData("")

    val closeScreen = SingleLiveEvent<Unit>()

    fun save() {
        val login = loginTextField.value ?: ""
        val password = passwordTextField.value ?: ""
        when {
            login.isEmpty() && password.isEmpty() -> {
                loginValidation.value = "Login is empty"
                passwordValidation.value = "Password is empty"
            }
            login.isEmpty() -> loginValidation.value = "Login is empty"
            password.isEmpty() -> passwordValidation.value = "Password is empty"
            else -> viewModelScope.launch {
                recordsRepository.save(login, password)
                closeScreen.value = Unit
            }
        }
    }


}