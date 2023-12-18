package com.biybiruza.broadcastsample

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var broadcastReceiver: MyBroadcastReceiver
    private lateinit var receiverMonitorBattery: MyReceiverMonitorBattery

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        broadcastReceiver = MyBroadcastReceiver()
        receiverMonitorBattery = MyReceiverMonitorBattery()

        //palyutga qo'yilgan vaziyat
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(broadcastReceiver, it)
        }

        //change battery
        IntentFilter(Intent.ACTION_BATTERY_CHANGED).also {
            registerReceiver(receiverMonitorBattery,it)
        }


    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(broadcastReceiver)
    }
}