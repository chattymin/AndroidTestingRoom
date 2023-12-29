package com.chattymin.kakaologintest

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.chattymin.kakaologintest.databinding.ActivityMainBinding
import com.kakao.sdk.common.KakaoSdk
import com.kakao.sdk.user.UserApiClient

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
    }
}
