package com.appsystems.restfulwebservice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    private Button getRequest;
    private TextView displayDataTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayDataTxt = findViewById(R.id.display_data_txt);
        displayDataTxt.setText(null);

        getRequest = findViewById(R.id.get_data);
        getRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO Fetch data event
            }
        });


    }

    public void sendRequest(View view)
    {
        final String url ="http://localhost:8080/api/v1/house";
        
    }
}
