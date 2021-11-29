package com.example.toplumesaj;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.awt.font.TextAttribute;
import java.util.List;


public class OzelAdapter extends BaseAdapter {

    private LayoutInflater mınflate;
    private List<Kisi> mKisiListesi;

    public OzelAdapter(Activity activity,List<Kisi> kisiler){
        mınflate=(LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mKisiListesi=kisiler;
    }

    @Override
    public int getCount() {
        return mKisiListesi.size();
    }

    @Override
    public Object getItem(int position) {
        return mKisiListesi.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View satirView=mınflate.inflate(R.layout.satir_ly,null);
        TextView textViewIsim=(TextView) satirView.findViewById(R.id.txt_ad);
        TextView textViewno=(TextView)  satirView.findViewById(R.id.txt_numara);
        ImageView imageView=(ImageView)  satirView.findViewById(R.id.img_av);


        Kisi kisi=mKisiListesi.get(position);
        textViewIsim.setText(kisi.getIsim());
        textViewno.setText((kisi.getTel_no()));

        if (kisi.photo !=null)
        {
            imageView.setImageBitmap(kisi.photo);
        }
        else{
            imageView.setImageResource(R.drawable.no_photo);
        }



        return satirView;
    }
}
