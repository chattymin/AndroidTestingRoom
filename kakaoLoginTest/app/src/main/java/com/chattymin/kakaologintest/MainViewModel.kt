package com.chattymin.kakaologintest

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel() : ViewModel() {
    private val _getFriendListState = MutableStateFlow<UiState<Unit>>(UiState.Empty)
    val getFriendListState: StateFlow<UiState<Unit>> = _getFriendListState
}
