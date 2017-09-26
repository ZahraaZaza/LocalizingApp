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

    public void sendCountryName(View v){
        String country = getResources().getString(R.string.country);
        Intent intent = new Intent(this, MapActivity.class);
        intent.putExtra("COUNTRY", country);
        startActivity(intent);
    }

    public void launchSearch(View view) {
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
        Log.d("TAG", "Launching MapActivity");
    }




}
