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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.countryName);

    }

    public void ImageClicked(){
        String country = tv.getText().toString();
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

        showMap(myUri);

    }

    public void showMap(Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
