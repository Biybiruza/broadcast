package com.biybiruza.broadcastsample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import android.widget.Toast

class MyReceiverMonitorBattery : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        val level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0)

        // isCharging if true indicates charging is ongoing and vice-versa
        val status: Int = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1) ?: -1
        val isCharging: Boolean = status == BatteryManager.BATTERY_STATUS_CHARGING
                || status == BatteryManager.BATTERY_STATUS_FULL

        // Display whatever the state in the form of a Toast
        if(isCharging) {
            if (level <= 15) {
                Toast.makeText(context, "Less than $level% charge left ",Toast.LENGTH_SHORT).show()
            } else if (level == 100) {
                Toast.makeText(context, "Charge is full, $level%",Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Batery $level%",Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(context,"Not Charging", Toast.LENGTH_SHORT).show()
        }
    }
}