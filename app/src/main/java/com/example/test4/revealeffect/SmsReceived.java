package com.example.test4.revealeffect;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import java.util.Objects;

/**
 * Created by bridgelabz4 on 3/2/16.
 */
public class SmsReceived extends BroadcastReceiver {

    final SmsManager smsM= SmsManager.getDefault();

    @Override
    public void onReceive(Context context, Intent intent) {
      final Bundle bundle=intent.getExtras();

        Log.e("y", "OTP is");
        String ti=intent.getStringExtra("hello");
        Toast.makeText(context,ti,Toast.LENGTH_SHORT).show();
       try {

        if(bundle != null){
            final Object[] sms1=(Object[]) intent.getExtras().get("hello");
            String smsstring=" ";

            for(int i=0;i<sms1.length;i++){
               SmsMessage smsMessage = SmsMessage.createFromPdu((byte[])sms1[i]);
               String phoneno=smsMessage.getDisplayOriginatingAddress();
               String senderno=phoneno;
               String smsbody=smsMessage.getDisplayMessageBody();
                 smsstring +="message from"+smsbody+"\n";
           }
            Toast.makeText(context,"hello"+smsstring+"hello",Toast.LENGTH_SHORT).show();

        }
        }catch (Exception e){
        Log.e("the","exception"+e);
        }
    }
}
