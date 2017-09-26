package com.horeibi.localizing;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;
import static android.provider.AlarmClock.EXTRA_MESSAGE;

/**
 * Created by Zahraa  on 2017-09-22.
 */

public class MapActivity extends Activity {
    EditText etLocation;
    TextView output;
    String location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        // get a handle on the text fields
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        location = intent.getStringExtra("COUNTRY");

        etLocation = (EditText) findViewById(R.id.inputLocation);

        output = (TextView) findViewById(R.id.output);

        etLocation.setText(location);

    }

    public void validateData(View v) {
            location = etLocation.getText().toString();
            Log.d("TAG", "Getting user input");

        if (!location.isEmpty()) {
            Log.d("TAG", "Valid Input");
            Uri geoLocation = Uri.parse("geo:0,0?q=" + Uri.encode(location));
            Intent geoIntent = new Intent(Intent.ACTION_VIEW);

            geoIntent.setData(geoLocation);
            if (geoIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(geoIntent);
                Log.d("TAG", "Launching google maps");
            } else {
                output.setText(R.string.errorNoGeo);
            }
        } else {
            output.setText(R.string.locationEmpty);
        }

    }

    /**
     * Does a google search of the user's input (assuming its always a location)
     * @param v
     */
    public void googleSearch(View v){
        location = etLocation.getText().toString();
        Log.d("TAG", "Getting user input");
        if(!location.isEmpty()) {
            Log.d("TAG", "Valid Input");
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
            // search string
            intent.putExtra(SearchManager.QUERY, location);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
                Log.d("TAG", "Launching google search");
            } else {
                output.setText(R.string.errorNoResult);
            }
        } else {
            output.setText(R.string.locationEmpty);
        }
    }


}
