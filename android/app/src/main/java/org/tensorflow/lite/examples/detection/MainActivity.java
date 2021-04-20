package org.tensorflow.lite.examples.detection;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;

import static android.text.TextUtils.isEmpty;

public class MainActivity extends AppCompatActivity {

    public boolean isConnecting = false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void startDetection(View view) {

        EditText hostField = findViewById(R.id.host);
        EditText portField = findViewById(R.id.port);


        Intent intent = new Intent(this, DetectorActivity.class);
        intent.putExtra("hostfield", hostField.getText().toString());
        intent.putExtra("portfield", portField.getText().toString());


        startActivity(intent);
    }

    @Override
    protected  void  onResume() {
        super.onResume();

        final Button startButton =  (Button) findViewById(R.id.startConnection);
        EditText hostField = findViewById(R.id.host);
        EditText portField = findViewById(R.id.port);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isConnecting ) {
                    startButton.setText("Stop");
                    hostField.setEnabled(false);
                    portField.setEnabled(false);
                    isConnecting = !isConnecting;
                }
                else {
                    startButton.setText("Start");
                    hostField.setEnabled(true);
                    portField.setEnabled(true);
                    isConnecting = !isConnecting;
                }
            }
        });


    }




}






