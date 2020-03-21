package com.nitolniloy.architecturecomponent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNoteActivity extends AppCompatActivity {

    public static final String NOTE_ADDED = "new_note";
    public static final String NOTE_DESC = "new_desc";
    private EditText etNewNote, etNewDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        etNewNote = findViewById(R.id.etNewNote);
        etNewDescription = findViewById(R.id.etNewDescription);
        Button button = findViewById(R.id.bAdd);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                Intent resultIntent = new Intent();

                if (TextUtils.isEmpty(etNewNote.getText())) {
                    setResult(RESULT_CANCELED, resultIntent);
                } else {
                    String note = etNewNote.getText().toString();
                    String desc = etNewDescription.getText().toString();
                    resultIntent.putExtra(NOTE_ADDED, note);
                    resultIntent.putExtra(NOTE_DESC, desc);
                    setResult(RESULT_OK, resultIntent);
                }

                finish();
            }
        });
    }
}
