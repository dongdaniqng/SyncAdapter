package com.ddq.syncadapter

import android.accounts.Account
import android.content.AbstractThreadedSyncAdapter
import android.content.ContentProviderClient
import android.content.Context
import android.content.SyncResult
import android.net.Uri
import android.os.Bundle
import android.util.Log

/**
 * Author : ddq
 * Time : 2019/12/31 12:39
 * Description :
 */
class SyncAdapter(context: Context,autoInit:Boolean):AbstractThreadedSyncAdapter(context,autoInit) {

    override fun onPerformSync(
        account: Account?,
        extras: Bundle?,
        authority: String?,
        provider: ContentProviderClient?,
        syncResult: SyncResult?
    ) {
        provider?.insert(Uri.parse("content://com.ddq.syncadapter.provider"),null)

        Log.e("tag",account?.name ?:"null")
        Log.e("tag", authority)

    }


}