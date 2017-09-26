package com.horeibi.localizing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.net.Uri;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    TextView outputError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.countryName);
        outputError = (TextView) findViewById(R.id.outputError);

    }

    public void showMap(View v){
       // String country = tv.getText().toString();
        String country = getResources().getString(R.string.country);

        Uri  geoLocation = Uri.parse("geo:0,0?q=" + Uri.encode(country));
        Intent geoIntent = new Intent(Intent.ACTION_VIEW);

        geoIntent.setData(geoLocation);
        if (geoIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(geoIntent);
        } else {
            outputError.setText(R.string.errorNoGeo);
        }

    }

    public void launchSearch(View view) {

        startActivity(new Intent(this, MapActivity.class));

    }



}
