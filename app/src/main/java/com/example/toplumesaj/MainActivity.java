package com.example.toplumesaj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.concurrent.RunnableFuture;

public class MainActivity extends AppCompatActivity {


    Button btn;
    EditText a;
    EditText b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
                btn =(Button) findViewById(R.id.btn_gr);
                a =(EditText) findViewById((R.id.txt1)) ;
                b =(EditText) findViewById((R.id.txt2));

                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        log();
                    }
                });




    }

    private void log() {
        String ads=a.getText().toString();
        String numara=b.getText().toString();

        if(ads.equals("umut durak") && numara.equals("201813709044") ){
            Intent mintent=new Intent(MainActivity.this,katman2.class);
            try {
                Thread.sleep(2000);


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            startActivity(mintent);
        }

    }


}
