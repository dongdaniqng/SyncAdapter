package com.ddq.syncadapter

import android.app.Service
import android.content.Intent
import android.os.IBinder

/**
 * Author : ddq
 * Time : 2019/12/31 12:43
 * Description :
 */
class SyncService:Service() {
    private lateinit var syncAdapter: SyncAdapter

    override fun onCreate() {
        super.onCreate()
        syncAdapter = SyncAdapter(this,true)
    }

    override fun onBind(intent: Intent?): IBinder? {
        return syncAdapter.syncAdapterBinder
    }
}