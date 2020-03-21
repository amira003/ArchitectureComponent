package com.nitolniloy.architecturecomponent;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final int UPDATE_NOTE_ACTIVITY_REQUEST_CODE = 2;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.i(TAG, "onCreate: Owner");
        getLifecycle().addObserver(new MainActivityObserver());

        // this textview will generate new number if we flip the screen
        // bcoz its dont use the viewmodel concept
        TextView txtRandomNumber = findViewById(R.id.txtRandomNumber);
        MainActivityDataGenerator generator = new MainActivityDataGenerator();
        Log.i(TAG, "onCreate: " + generator.getMyNumber());
        txtRandomNumber.setText(generator.getMyNumber());

        // this textview will user the same number even if we flip the screen
        // bcoz its use the viewmodel concept
        TextView txtRandomNumberViewModel = findViewById(R.id.txtRandomNumberViewModel);
        MainActivityViewModel model = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        Log.i(TAG, "onCreate: " + model.getMyNumber());
        txtRandomNumberViewModel.setText(model.getMyNumber());

        final TextView txtRandomNumberViewModelMutableData = findViewById(R.id.txtRandomNumberViewModelMutableData);
        final MainActivityViewModel mutableModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        final LiveData<String> mutableNumber = mutableModel.getMyMutableNumber();
        mutableNumber.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                txtRandomNumberViewModelMutableData.setText(s);
            }
        });

        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mutableModel.createMutableNumber();
            }
        });

    }

    @Override
    protected void onStart() {
        Log.i(TAG, "onStart: Owner");
        super.onStart();
    }

    @Override
    protected void onPause() {
        Log.i(TAG, "onPause: Owner");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.i(TAG, "onResume: Owner");
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "onDestroy: Owner");
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        Log.i(TAG, "onStop: Owner");
        super.onStop();
    }
}
