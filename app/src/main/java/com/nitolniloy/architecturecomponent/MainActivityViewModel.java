package com.nitolniloy.architecturecomponent;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;
import java.util.Random;

public class MainActivityViewModel extends ViewModel {

    private static final String TAG = "MainActivityViewModel";

    private String myNumber;
    private MutableLiveData<String> myMutableNumber;

    public String getMyNumber(){
        if (myNumber == null)
            createMyNumber();
        return myNumber;
    }

    private void createMyNumber() {
        Log.i(TAG, "createMyNumber: ");
        Random random = new Random();
        myNumber = "ViewModel: Number: " + (random.nextInt(10-1) + 1);
    }

    @Override
    protected void onCleared() {
        Log.i(TAG, "View Model Destroyed: ");
        super.onCleared();
    }
    
    public MutableLiveData<String> getMyMutableNumber(){
        Log.i(TAG, "getMyMutableNumber: ");
        if (myMutableNumber == null){
            myMutableNumber = new MutableLiveData<>();
            createMyNumber();
        }
        return myMutableNumber;
    }
    
    public void createMutableNumber(){
        Log.i(TAG, "createMutableNumber: ");
        Random random = new Random();
        myMutableNumber.setValue("Mutable: Number: " + (random.nextInt(10-1) + 1));
    }
}
