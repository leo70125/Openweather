package com.example.openweather3day;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button star;
    private EditText ed_search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_search = findViewById(R.id.ed_search);
        star = findViewById(R.id.bt_st);
        SharedPreferences  sharedPreferences = this.getSharedPreferences("share",MODE_PRIVATE);
        boolean isFirstRun = sharedPreferences.getBoolean("isFirstRun",true);
        SharedPreferences.Editor editor=sharedPreferences.edit();
            if(isFirstRun){
                Toast.makeText(MainActivity.this,"歡迎使用天氣查詢app",Toast.LENGTH_SHORT).show();
                editor.putBoolean("isFirstRun",false);
                editor.commit();
            }else {
                Toast.makeText(MainActivity.this,"歡迎回來",Toast.LENGTH_SHORT).show();;
            }
        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  City = ed_search.getText().toString();
                Intent intent = new Intent(MainActivity.this,Openweather.class);
                intent.putExtra("City",City);
                startActivity(intent);


            }
        });
    }
}
