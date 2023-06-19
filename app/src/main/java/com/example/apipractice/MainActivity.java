package com.example.apipractice;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.example.apipractice.Adapter.MyAdapter;
import com.example.apipractice.Model.Model;
import com.example.apipractice.applications.MyApplication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.sql.StatementEvent;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
MyAdapter myAdapter;
String TAG = MainActivity.class.getSimpleName();
ArrayList<Model> model=new ArrayList<>();
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fetch();
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void fetch(){

        String Url = "https://api.nasa.gov/planetary/apod";
        String apiKey = "HERE ADD YOUR NASA OPEN API";
            AndroidNetworking.get(Url).addQueryParameter("api_key", apiKey)
                    .setPriority(Priority.LOW)
                    .build()
                    .getAsObject(Model.class, new ParsedRequestListener<Model>() {
                        @Override
                        public void onResponse(Model response) {
                            Toast.makeText(MainActivity.this, "Data fetched successfully", Toast.LENGTH_SHORT).show();
                            model.add(response);
                            myAdapter = new MyAdapter(getApplicationContext(), model);
                            recyclerView.setAdapter(myAdapter);
                        }

                        @Override
                        public void onError(ANError anError) {
                            Log.e(TAG, "Error" + anError + "\n \n \n" + anError.getErrorDetail() + "\n \n \n" + anError.getErrorBody());
                        }
                    });
    }
}