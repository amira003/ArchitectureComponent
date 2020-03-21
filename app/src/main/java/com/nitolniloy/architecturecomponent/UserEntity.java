package com.nitolniloy.architecturecomponent;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "tblUsers")
public class UserEntity {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    @NonNull
    private String userId;

    @NonNull
    private String userName;

    @NonNull
    private String email;

    @NonNull
    private String password;

    @NonNull
    private String addressId;

    private String geoId;

    @NonNull
    private String phone;

    private String website;

    private String companyId;

    public UserEntity() {
    }

    public UserEntity(@NonNull String userId, @NonNull String userName, @NonNull String email,
                      @NonNull String password, @NonNull String addressId, @NonNull String phone) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.addressId = addressId;
        this.phone = phone;
    }

    public UserEntity(@NonNull String userId, @NonNull String userName, @NonNull String email, @NonNull String password,
                      @NonNull String addressId, String geoId, @NonNull String phone, String website, String companyId) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.addressId = addressId;
        this.geoId = geoId;
        this.phone = phone;
        this.website = website;
        this.companyId = companyId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getUserId() {
        return userId;
    }

    public void setUserId(@NonNull String userId) {
        this.userId = userId;
    }

    @NonNull
    public String getUserName() {
        return userName;
    }

    public void setUserName(@NonNull String userName) {
        this.userName = userName;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    @NonNull
    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(@NonNull String addressId) {
        this.addressId = addressId;
    }

    public String getGeoId() {
        return geoId;
    }

    public void setGeoId(String geoId) {
        this.geoId = geoId;
    }

    @NonNull
    public String getPhone() {
        return phone;
    }

    public void setPhone(@NonNull String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", addressId='" + addressId + '\'' +
                ", geoId='" + geoId + '\'' +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                ", companyId='" + companyId + '\'' +
                '}';
    }
}
