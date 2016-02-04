package com.example.test4.revealeffect;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.TextView;

import java.util.Objects;

/**
 * Created by bridgelabz4 on 4/2/16.
 */
//public class Read extends BroadcastReceiver {
//    TextView t1;
//
//    @Override
//    public void onReceive(Context context, Intent intent) {
//
//
//        Object[] ob=(Object []) intent.getExtras().get("bund");
//        for(Object b:ob){
//            SmsMessage smsMessage=SmsMessage.createFromPdu((byte[])b);
//            if(smsMessage.getMessageBody().contains("OTP")){
//                Log.w("sms:"+smsMessage.getOriginatingAddress(),smsMessage.getMessageBody());
//            }
//        }
//    }
//}
