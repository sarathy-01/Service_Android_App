package com.example.service;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Toast;

public class SMSService extends Service {
    public SMSService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
            String phoneNumber = intent.getStringExtra("phoneNumber");
            String message = intent.getStringExtra("message");

            sendSMS(phoneNumber, message);
        }

        return super.onStartCommand(intent, flags, startId);
    }

    private void sendSMS(String phoneNumber, String message) {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber, null, message, null, null);
            Toast.makeText(this, "SMS sent", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();

            Log.e("MyTag", "Error occurred:", e);

            Toast.makeText(this, "Failed to send SMS"+phoneNumber+"hi", Toast.LENGTH_SHORT).show();
        }
    }
}
