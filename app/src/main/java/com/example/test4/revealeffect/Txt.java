package com.example.test4.revealeffect;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Random;

/**
 * Created by bridgelabz4 on 3/2/16.
 */
public class Txt extends AppCompatActivity {
    EditText Number,msg;
    TextView t1;
    Button b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.smslayout);
        Number=(EditText)findViewById(R.id.edit1);
        msg=(EditText)findViewById(R.id.edit2);
        b2=(Button)findViewById(R.id.btn1);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                int r1 = 10000 + r.nextInt(50000);
                String Phoneno = Number.getText().toString();
                String ap = "Your OTP is " + r1 + "it is 5 digit number";
                String TxtMsg = ap;
                Toast.makeText(Txt.this, "here" + r1, Toast.LENGTH_SHORT).show();
                if (Phoneno.length() > 0 && TxtMsg.length() > 0) {
                    sendmessage(Phoneno, TxtMsg);
                    //to call another message

                    //readmsg();

                } else {
                    Toast.makeText(Txt.this, "Invalid Number or Message", Toast.LENGTH_SHORT).show();


                }

                Intent i= new Intent();
                i.setAction("android.provider.Telephony.SMS_RECEIVED");
                i.putExtra("hello",ap);
                sendBroadcast(i);
                //Toast.makeText(Txt.this, "here123" + r1, Toast.LENGTH_SHORT).show();



            }
        });


    }

    private void readmsg() {
        //read msg
//
//        t1=(TextView)findViewById(R.id.txtread);
//        Uri sms=Uri.parse("content://sms/inbox");
//
//        Cursor cur=getContentResolver().query(sms,null,null,null,null);
//        Toast.makeText(Txt.this,"read msg"+cur,Toast.LENGTH_SHORT).show();
//        String smsread=" ";
//        while(cur.moveToNext()){
//            smsread+=":from"+cur.getString(2)+" :"+cur.getString(11)+"\n";
//            Toast.makeText(Txt.this,"msg"+smsread,Toast.LENGTH_SHORT).show();
//        }
//        t1.setText(smsread);
//        setContentView(t1);

    }

    private void sendmessage(String phoneno, String txtMsg) {
        try {

            SmsManager smsManager=SmsManager.getDefault();
            smsManager.sendTextMessage(phoneno,null,txtMsg,null,null);
            Toast.makeText(Txt.this,"Message is sent",Toast.LENGTH_SHORT).show();

        }catch (Exception e)
        {
            Toast.makeText(Txt.this,"Message is not sent",Toast.LENGTH_SHORT).show();
            e.printStackTrace();


        }
    }
}
