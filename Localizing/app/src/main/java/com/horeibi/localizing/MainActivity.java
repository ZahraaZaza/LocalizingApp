package com.horeibi.localizing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.net.Uri;
import static android.provider.AlarmClock.EXTRA_MESSAGE;

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

        /*
        String latitude = "";
        String longitude = "";
        String geo = "geo:";

        switch (country){
            case "Canada":
                    latitude = "56.1304";
                    longitude = "-106.3468";
                break;

            case "USA":
                    latitude = "37.0902";
                    longitude = "-95.7129";
                break;

            case "Italia":
                latitude = "41.8719";
                longitude = "12.5674";
                break;

            case "France":
                latitude = "46.2276";
                longitude = "2.2137";
                break;

            case "Russia":
                latitude = "61.5240";
                longitude = "105.3188";
                break;
        }

        geo += latitude + "," + longitude;

        //Uri myUri = Uri.parse("geo:0,0?q=" + Uri.encode("Montreal"));

        Uri myUri = Uri.parse(geo);
        */


    }

    public void launchSearch(View view) {
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
        Log.d("TAG", "Launching MapActivity");
    }



}
