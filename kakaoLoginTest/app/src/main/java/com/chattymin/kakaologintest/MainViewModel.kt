package com.chattymin.kakaologintest

import android.content.Context
import androidx.lifecycle.ViewModel
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.user.UserApiClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel() : ViewModel() {
    private val _getKakaoDataState = MutableStateFlow<UiState<Unit>>(UiState.Empty)
    val getKakaoDataState: StateFlow<UiState<Unit>> = _getKakaoDataState

//    // 웹 로그인 실행
//    fun loginWithWebCallback(
//        context: Context,
//        callback: (token: OAuthToken?, error: Throwable?) -> Unit,
//    ) {
//        UserApiClient.instance.loginWithKakaoAccount(
//            context = context,
//            callback = callback,
//            serviceTerms = serviceTermsList,
//        )
//    }
//
//    // 앱 로그인 실행
//    fun loginWithAppCallback(
//        context: Context,
//        callback: (token: OAuthToken?, error: Throwable?) -> Unit,
//    ) {
//        UserApiClient.instance.loginWithKakaoTalk(
//            context = context,
//            callback = callback,
//            serviceTerms = serviceTermsList,
//        )
//    }
//
//    // 카카오 통신 - 카카오 유저 정보 받아오기
//    fun getKakaoInfo() {
//        UserApiClient.instance.me { user, _ ->
//            _getKakaoDataState.value = UiState.Loading
//            try {
//                if (user != null) {
//                    _getKakaoDataState.value = UiState.Success(user)
//                    return@me
//                }
//            } catch (e: IllegalArgumentException) {
//                _getKakaoDataState.value = UiState.Failure(e.message ?: "")
//            }
//        }
//        _getKakaoDataState.value = UiState.Failure("카카오 정보 불러오기 실패")
//    }
}
