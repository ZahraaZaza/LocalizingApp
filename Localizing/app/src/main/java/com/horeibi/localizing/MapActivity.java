package com.horeibi.localizing;

import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

/**
 * Created by Zahraa  on 2017-09-22.
 */

public class MapActivity extends Activity {
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

    public void validateData(View v) {
        String location = etLocation.getText().toString();
        Log.d("TAG", "Getting user input");
        if (location != null) {
            Uri geoLocation = Uri.parse("geo:0,0?q=" + Uri.encode(location));
            Intent geoIntent = new Intent(Intent.ACTION_VIEW);

            geoIntent.setData(geoLocation);
            if (geoIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(geoIntent);
                Log.d("TAG", "Valid input, launching google maps");
            } else {
                output.setText(R.string.errorNoGeo);
            }
        } else {
            output.setText(R.string.locationEmpty);
        }

    }

}
