package com.example.service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class AirplaneModeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null && intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)) {
            boolean isAirplaneModeOn = isAirplaneModeOn(context);
            // Do something with the airplane mode state
            if (isAirplaneModeOn) {
                // Airplane mode is on
                // Handle airplane mode being turned on
                Toast.makeText(context, "PLEASE OF THE AIROPLANE MODE", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(Settings.ACTION_AIRPLANE_MODE_SETTINGS);
                context.startActivity(intent1);

            } else {
                // Airplane mode is off
                // Handle airplane mode being turned off
                Toast.makeText(context, "PLEASE ON THE ", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean isAirplaneModeOn(Context context) {
        return Settings.System.getInt(context.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON, 0) != 0;
    }
}
