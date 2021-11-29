package com.example.toplumesaj;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class katman2 extends AppCompatActivity {

    final List<Kisi> kisiler=new ArrayList<Kisi>();
    ArrayList<String> akrabaisim=new ArrayList<>();
    ArrayList<String> akrabano=new ArrayList<>();
    ArrayList<String> arkadasisim=new ArrayList<>();
    ArrayList<String> arkadasno=new ArrayList<>();
    ArrayList<String> isisim=new ArrayList<>();
    ArrayList<String> isno=new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_katman2);

        ListView listem=(ListView) findViewById(R.id.lv_katman2);
        RadioButton rb1=(RadioButton) findViewById(R.id.rb_akraba);
        RadioButton rb2=(RadioButton) findViewById(R.id.rb_arkadas);
        RadioButton rb3=(RadioButton) findViewById(R.id.rb_is);
        Button btn=(Button) findViewById(R.id.sms_git);


        OzelAdapter adapter=new OzelAdapter(this,kisiler);
        listem.setAdapter(adapter);


        final Uri content_Uri= ContactsContract.Contacts.CONTENT_URI;
        final String Id =ContactsContract.Contacts._ID;
        final String Isim =ContactsContract.Contacts.DISPLAY_NAME;
        final String Tel_durum =ContactsContract.Contacts.HAS_PHONE_NUMBER;

        final Uri phone_uri=ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        final String phone_ID=ContactsContract.CommonDataKinds.Phone.CONTACT_ID;
        final String phone_number=ContactsContract.CommonDataKinds.Phone.NUMBER;


        ContentResolver contentResolver =getContentResolver();

        Cursor cursor=contentResolver.query(content_Uri,null,null,null,null);

        while(cursor.moveToNext())
        {
            @SuppressLint("Range") String kisi_id=cursor.getString(cursor.getColumnIndex(Id));
            @SuppressLint("Range") String kisi_isim=cursor.getString(cursor.getColumnIndex(Isim));
            @SuppressLint("Range") String tel_durum=cursor.getString(cursor.getColumnIndex(Tel_durum));

            Bitmap photo=null;

            try {
                InputStream inputStream=ContactsContract.Contacts.openContactPhotoInputStream
                        (getContentResolver(), ContentUris.withAppendedId(content_Uri,Long.valueOf(kisi_id)));

                if (inputStream!=null){
                    photo = BitmapFactory.decodeStream(inputStream);
                }
                if (inputStream!=null){
                    assert inputStream!=null;
                    inputStream.close();
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
            if (tel_durum.equals("1")){
                Cursor phoneCursor=contentResolver.query(phone_uri,null,phone_ID +"=?",new String[] {kisi_id},null);

                while (phoneCursor.moveToNext()){
                    @SuppressLint("Range") final String t=phoneCursor.getString(phoneCursor.getColumnIndex(phone_number));
                    Kisi k =new Kisi(kisi_isim,t);
                    k.photo=photo;
                    kisiler.add(k);
                }
                phoneCursor.close();

            }


        }
        listem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (rb1.isChecked()==true)
                {
                    akrabaisim.add(kisiler.get(position).getIsim());
                    akrabano.add(kisiler.get(position).getTel_no());
                    rb1.setChecked(false);
                }
                if (rb2.isChecked()==true)
                {
                    arkadasisim.add(kisiler.get(position).getIsim());
                    arkadasno.add(kisiler.get(position).getTel_no());
                    rb2.setChecked(false);
                }
                if (rb3.isChecked()==true)
                {
                    isisim.add(kisiler.get(position).getIsim());
                    isno.add(kisiler.get(position).getTel_no());
                    rb3.setChecked(false);
                }

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intents=new Intent(getApplicationContext(),katman3.class);

                intents.putExtra("akrabaisim",akrabaisim);
                intents.putExtra("akrabano",akrabano);
                intents.putExtra("arkadasisim",arkadasisim);
                intents.putExtra("arkadasno",arkadasno);
                intents.putExtra("isisim",isisim);
                intents.putExtra("isno",isno);

                startActivity(intents);


            }
        });












    }
}