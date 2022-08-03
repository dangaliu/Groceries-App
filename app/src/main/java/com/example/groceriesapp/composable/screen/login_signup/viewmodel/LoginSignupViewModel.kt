package com.example.groceriesapp.composable.screen.login_signup.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class LoginSignupViewModel @Inject constructor(): ViewModel() {

    private val _state = mutableStateOf(LoginSignupState.LOGIN)
    val state: State<LoginSignupState> = _state

    fun changeState(state: LoginSignupState) {
        _state.value = state
    }
}

enum class LoginSignupState {
    LOGIN, SIGNUP
}