package com.taz.vize;

import androidx.appcompat.app.AppCompatActivity;
import android.Manifest;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Sms extends AppCompatActivity {
    private EditText telefon,messsage;
    private Button gonderBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        telefon = findViewById(R.id.inputPhone);
        messsage = findViewById(R.id.inputMessage);
        gonderBtn = findViewById(R.id.Btn4);

        gonderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(Sms.this,Manifest.permission.SEND_SMS)==
                        PackageManager.PERMISSION_GRANTED){
                    sendSms();
                }
                else {
                    ActivityCompat.requestPermissions(Sms.this, new String[]{Manifest.permission.SEND_SMS}, 100);

                }
            }
        });
    }
    private void sendSms(){
        String phone = telefon.getText().toString();
        String mesa = messsage.getText().toString();
        if (!phone.isEmpty() && !mesa.isEmpty()){
            SmsManager smsManager=SmsManager.getDefault();

            smsManager.sendTextMessage(phone,null,mesa,null,null);
            Toast.makeText(this,"Başarılı",Toast.LENGTH_SHORT).show();

        }
        else { Toast.makeText(this,"Başarısız",Toast.LENGTH_SHORT).show();
        }

    }
}