package com.horeibi.localizing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Zahraa on 2017-09-22.
 */

public class MapActivity extends AppCompatActivity {
    EditText etLocation;
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        // get a handle on the text fields
        etLocation = (EditText) findViewById(R.id.inputLocation);
        output = (TextView) findViewById(R.id.output);

    }

    public void validateData() {
        String location = etLocation.getText().toString();

        if (location != null) {

        } else {
            output.setText(R.string.locationEmpty);
        }

    }

}
