package com.nitolniloy.architecturecomponent;

import android.util.Log;
import java.util.Random;

public class MainActivityDataGenerator {

    private static final String TAG = "MainActivityDataGenerat";

    private String myNumber;

    public String getMyNumber(){
        if (myNumber == null)
            createMyNumber();
        return myNumber;
    }

    private void createMyNumber() {
        Log.i(TAG, "createMyNumber: ");
        Random random = new Random();
        myNumber = "Number: " + (random.nextInt(10-1) + 1);
    }

}
