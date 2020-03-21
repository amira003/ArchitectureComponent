package com.nitolniloy.architecturecomponent;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


@Entity(tableName = "notes")
public class Note {

    @PrimaryKey
    @NonNull
    private String noteId;

    @NonNull
    private String noteTitle;

    @NonNull
    private String noteDesc;

    public Note(@NonNull String noteId, @NonNull String noteTitle, @NonNull String noteDesc) {
        this.noteId = noteId;
        this.noteTitle = noteTitle;
        this.noteDesc = noteDesc;
    }

    @NonNull
    public String getNoteId() {
        return noteId;
    }

    @NonNull
    public String getNoteTitle() {
        return noteTitle;
    }

    @NonNull
    public String getNoteDesc() {
        return noteDesc;
    }
}
