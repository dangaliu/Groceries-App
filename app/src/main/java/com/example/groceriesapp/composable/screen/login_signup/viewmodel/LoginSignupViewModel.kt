package com.example.groceriesapp.composable.screen.login_signup.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class LoginSignupViewModel @Inject constructor(): ViewModel() {

}

enum class LoginSignupState {
    LOGIN, SIGNUP
}