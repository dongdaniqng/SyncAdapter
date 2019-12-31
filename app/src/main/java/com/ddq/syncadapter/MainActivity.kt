package com.ddq.syncadapter

import android.accounts.Account
import android.accounts.AccountManager
import android.content.ContentResolver
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createAccount()
    }

    private fun createAccount() {
        val account = Account("ddq", getString(R.string.package_name))
        val accountManager = getSystemService(Context.ACCOUNT_SERVICE) as AccountManager
        val r = accountManager.addAccountExplicitly(account, null, null)
        Log.e("tag", r.toString())


        ContentResolver.setIsSyncable(account,getString(R.string.provider),1)
        ContentResolver.setSyncAutomatically(account,getString(R.string.provider),true)
        ContentResolver.addPeriodicSync(account,getString(R.string.provider), Bundle.EMPTY,60)
        //ContentResolver.requestSync(account,getString(R.string.provider), Bundle.EMPTY)
    }
}
