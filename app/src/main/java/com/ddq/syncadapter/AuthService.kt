package com.ddq.syncadapter

import android.app.Service
import android.content.Intent
import android.os.IBinder

/**
 * Author : ddq
 * Time : 2019/12/31 12:08
 * Description :
 */
class AuthService : Service() {
    private lateinit var auth: Auth
    override fun onCreate() {
        super.onCreate()
        auth = Auth(applicationContext)
    }

    override fun onBind(intent: Intent?): IBinder? {
        return auth.iBinder
    }
}