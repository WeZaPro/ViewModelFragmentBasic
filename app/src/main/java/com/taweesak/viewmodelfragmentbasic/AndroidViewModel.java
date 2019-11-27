package com.taweesak.viewmodelfragmentbasic;

import android.app.Application;
import android.graphics.drawable.Drawable;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class AndroidViewModel extends androidx.lifecycle.AndroidViewModel {

    MutableLiveData<ModelNumber> number;
    private Drawable image;

    public AndroidViewModel(@NonNull Application application) {
        super(application);
        number = new MutableLiveData<ModelNumber>();
    }

    ModelNumber getNumber() {
        return number.getValue();
    }

    // รับค่าเข้่ามา
    void setNumber(ModelNumber item){
        number.setValue(item);
        //Toast.makeText(getApplication(),"Text is "+item,Toast.LENGTH_SHORT).show();
    }

    //ส่งค่าออกไป
    public LiveData<ModelNumber> getData(){
        return number;
    }

    // Image
    /*public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }*/

}
