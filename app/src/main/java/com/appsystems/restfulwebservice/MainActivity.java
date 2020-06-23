package com.appsystems.restfulwebservice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

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
        new RESTTask().execute(url);
    }

    class RESTTask extends AsyncTask<String,Void, ResponseEntity<House>>
    {

        @Override
        protected ResponseEntity<House> doInBackground(String... uri) {

            final String url = uri[0];
            RestTemplate restTemplate = new RestTemplate();
            try{

                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

                HttpHeaders header = new HttpHeaders();

                String auth = "marco"+":"+"polo";
                String encodeAuth = Base64.encodeToString(auth.getBytes(),Base64.DEFAULT);
                String authHeader = "Basic"+ encodeAuth;
                header.set("Authorization",authHeader);

                HttpEntity<String>entity = new HttpEntity<String>(header);

                ResponseEntity<House>response = restTemplate.exchange(url, HttpMethod.GET,entity,House.class);

                return response;

            }
            catch(Exception e)
            {
                e.printStackTrace();
                return null;
            }

        }
    }
}
