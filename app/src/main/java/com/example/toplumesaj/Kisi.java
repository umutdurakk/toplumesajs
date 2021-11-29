package com.example.toplumesaj;

import android.graphics.Bitmap;

import androidx.annotation.NonNull;

public class Kisi {
    private String isim;
    private String tel_no;
    public Bitmap photo=null;

    public Kisi(String isim,String tel_no){
        super();
        this.isim=isim;
        this.tel_no=tel_no;

    }


    public void setTel_no(String tel_no) {
        this.tel_no = tel_no;
    }

    public void setPhoto(Bitmap photo) {
        this.photo = photo;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getTel_no() {
        return tel_no;
    }

    public String getIsim() {
        return isim;
    }

    public Bitmap getPhoto() {
        return photo;
    }

}
