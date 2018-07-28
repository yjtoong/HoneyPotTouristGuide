package com.inti.student.honeypottouristguide;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity{

    DatabaseHelper HoneyPotDB;

    private TextView mTextView = (TextView)findViewById(R.id.textView_usd);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);
        Cursor data = HoneyPotDB.getListContents();
        mTextView.setText(data.getString(2));
    }
}
