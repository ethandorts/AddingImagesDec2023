package com.example.addingimagesdec2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    String radioButtonID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (checkedId == R.id.radioButton1) {
                    radioButtonID = "drawable";
                } else if (checkedId == R.id.radioButton2) {
                    radioButtonID = "sdcard";
                }
            }
        });
    }
    public void DisplayImage(View view) {
        Intent intent = new Intent(this, DisplayImageActivity.class);
        intent.putExtra("SelectedRadioButton", radioButtonID);
        startActivity(intent);
    }
}