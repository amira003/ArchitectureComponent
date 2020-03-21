package com.nitolniloy.architecturecomponent;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

@Dao
public interface UserDao {

    @Insert
    void insertUser(UserModel userModel);

}
