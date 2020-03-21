package com.nitolniloy.architecturecomponent;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddUserActivity extends AppCompatActivity {
    private static final String TAG = "AddUserActivity";

    private Button btnAddUser;
    private EditText etUserName, etUserId, etEmail, etPassword, etAddressId, etGeoId, etPhone, etWebsite, etCompanyId;
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        initWidget();
    }

    private void initWidget() {
        Log.i(TAG, "initWidget: ");

        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);

        etUserName = findViewById(R.id.etUserName);
        etUserId = findViewById(R.id.etUserId);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etAddressId = findViewById(R.id.etAddressId);
        etGeoId = findViewById(R.id.etGeoId);
        etPhone = findViewById(R.id.etPhone);
        etWebsite = findViewById(R.id.etWebsite);
        etCompanyId = findViewById(R.id.etCompanyId);

        btnAddUser = findViewById(R.id.btnAddUser);
        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userName = etUserName.getText().toString().trim();
                String userId = etUserId.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                String addressId = etAddressId.getText().toString().trim();
                String geoId = etGeoId.getText().toString().trim();
                String phone = etPhone.getText().toString().trim();
                String website = etWebsite.getText().toString().trim();
                String company = etCompanyId.getText().toString().trim();

                UserEntity userModel = new UserEntity(userId, userName, email, password, addressId, geoId, phone, website, company);
                userViewModel.insertUser(userModel);
                Toast.makeText(AddUserActivity.this, "User Added", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
