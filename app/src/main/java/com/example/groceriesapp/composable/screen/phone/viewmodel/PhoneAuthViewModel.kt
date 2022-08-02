package com.example.groceriesapp.composable.screen.phone.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PhoneAuthViewModel @Inject constructor(): ViewModel() {

    private val _phoneAuthState = mutableStateOf(PhoneAuthState.PHONE)
    val phoneAuthState: State<PhoneAuthState> = _phoneAuthState


    fun changeState(state: PhoneAuthState) {
        _phoneAuthState.value = state
    }
}

enum class PhoneAuthState {
    PHONE, CODE
}