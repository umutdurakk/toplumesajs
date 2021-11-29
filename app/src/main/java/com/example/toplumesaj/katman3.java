package com.example.toplumesaj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class katman3 extends AppCompatActivity {

    ListView a;
    Button gonder;
    EditText mesaj;

    ArrayList<String> akrabaisim=new ArrayList<>();
    ArrayList<String> akrabano=new ArrayList<>();
    ArrayList<String> arkadasisim=new ArrayList<>();
    ArrayList<String> arkadasno=new ArrayList<>();
    ArrayList<String> isisim=new ArrayList<>();
    ArrayList<String> isno=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_katman3);

        RadioButton rb1 =(RadioButton)  findViewById(R.id.rb_1);
        RadioButton rb2 =(RadioButton)  findViewById(R.id.rb_2);
        RadioButton rb3 =(RadioButton)  findViewById(R.id.rb_3);
        a=(ListView) findViewById(R.id.lv_kt3);

        gonder=(Button) findViewById(R.id.btn_gonder);
        mesaj=(EditText) findViewById(R.id.txt_mesaj);

        Intent intent=getIntent();


        akrabaisim=intent.getStringArrayListExtra("akrabaisim");
        akrabano=intent.getStringArrayListExtra("akrabano");
        arkadasisim=intent.getStringArrayListExtra("arkadasisim");
        arkadasno=intent.getStringArrayListExtra("arkadasno");
        isisim=intent.getStringArrayListExtra("isisim");
        isno=intent.getStringArrayListExtra("isno");

        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rb2.setChecked(false);
                rb3.setChecked(false);
                bir();
            }
        });

        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rb1.setChecked(false);
                rb3.setChecked(false);
                iki();
            }
        });
        rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rb2.setChecked(false);
                rb1.setChecked(false);
                uc();
            }
        });

        gonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rb1.isChecked()==true)
                {
                    android.telephony.SmsManager sms=
                            android.telephony.SmsManager.getDefault();
                    for (int i=0;i<akrabano.size();i++)
                    {
                        sms.sendTextMessage(akrabano.get(i).toString(),null,mesaj.getText().toString(),null,null);
                        try {
                            TimeUnit.SECONDS.sleep(1);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_APP_MESSAGING);
                    startActivity(intent);
                }
               else if(rb2.isChecked()==true)
                {
                    android.telephony.SmsManager sms=
                            android.telephony.SmsManager.getDefault();
                    for (int i=0;i<arkadasno.size();i++)
                    {
                        sms.sendTextMessage(arkadasno.get(i).toString(),null,mesaj.getText().toString(),null,null);
                        try {
                            TimeUnit.SECONDS.sleep(1);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_APP_MESSAGING);
                    startActivity(intent);
                }
                else if(rb3.isChecked()==true)
                {
                    android.telephony.SmsManager sms=
                            android.telephony.SmsManager.getDefault();
                    for (int i=0;i<isno.size();i++)
                    {
                        sms.sendTextMessage(isno.get(i).toString(),null,mesaj.getText().toString(),null,null);
                        try {
                            TimeUnit.SECONDS.sleep(1);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_APP_MESSAGING);
                    startActivity(intent);
                }
            }
        });





    }


    private void bir() {
        ArrayAdapter<String> adapter1=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item
        ,akrabaisim);
        a.setAdapter(adapter1);

    }
    private void iki() {
        ArrayAdapter<String> adapter2=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item
                ,arkadasisim);
        a.setAdapter(adapter2);

    }
    private void uc() {
        ArrayAdapter<String> adapter3=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item
                ,isisim);
        a.setAdapter(adapter3);

    }

}