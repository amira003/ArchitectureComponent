package com.nitolniloy.architecturecomponent;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

public class UserViewModel extends AndroidViewModel {

    private String TAG = this.getClass().getSimpleName();
    private UserDao userDao;
    private NoteRoomDatabase noteDB;

    public UserViewModel(@NonNull Application application) {
        super(application);
        noteDB = NoteRoomDatabase.getDatabase(application);
        userDao = noteDB.userDao();
    }

    public void insertUser(UserEntity userModel) {
        new InsertAsyncTask(userDao).execute(userModel);
    }

    private class InsertAsyncTask extends AsyncTask<UserEntity, Void, Void> {

        UserDao mUserDao;
        InsertAsyncTask(UserDao mUserDao) {
            this.mUserDao = mUserDao;
        }

        @Override
        protected Void doInBackground(UserEntity... userModels) {
            mUserDao.insertUser(userModels[0]);
            return null;
        }
    }


}
