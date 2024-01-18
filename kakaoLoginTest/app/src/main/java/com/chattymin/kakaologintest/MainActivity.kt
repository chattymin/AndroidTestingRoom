package com.chattymin.kakaologintest

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.flowWithLifecycle
import com.chattymin.kakaologintest.databinding.ActivityMainBinding
import com.kakao.sdk.common.KakaoSdk
import com.kakao.sdk.user.UserApiClient
import kotlinx.coroutines.flow.onEach

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.etOnboardingProfileSettingName.setError("error")

        KakaoSdk.init(this, BuildConfig.APP_KEY)
        UserApiClient.instance.loginWithKakaoTalk(this) { token, error ->
            if (error != null) {
                Log.e(TAG, "로그인 실패", error)
            } else if (token != null) {
                Log.i(TAG, "Access Token - ${token.accessToken}")
                Log.i(TAG, "Refresh Token - ${token.refreshToken}")
            }
        }

        UserApiClient.instance.me { user, error ->
            if (error != null) {
                Log.e(TAG, "사용자 정보 요청 실패 $error")
            } else if (user != null) {
                Log.e(TAG, "사용자 정보 요청 성공 : $user")
                Log.e(TAG, "nickname: ${user.kakaoAccount?.profile?.nickname}")
                Log.e(TAG, "age: ${user.kakaoAccount?.ageRange}")
                Log.e(TAG, "email: ${user.kakaoAccount?.email}")
            }
        }

        setContentView(binding.root)

        test()
    }

    private fun test() {
        val progress = findViewById<ProgressBar>(R.id.progress)
        progress.setProgress(50) // range 0-100
    }

    private fun observeKakaoUserDataState() {
        mainViewModel.getKakaoDataState.flowWithLifecycle(lifecycle).onEach { state ->
            when (state) {
                is UiState.Success -> {
                    // startSocialSyncActivity(state.data)
                }

                is UiState.Failure -> {
                    // yelloSnackbar(binding.root, getString(R.string.msg_error))
                }

                is UiState.Empty -> {}

                is UiState.Loading -> {}
            }
        }
    }
}
