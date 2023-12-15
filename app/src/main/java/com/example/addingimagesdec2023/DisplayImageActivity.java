package com.example.addingimagesdec2023;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class DisplayImageActivity extends AppCompatActivity {
    Button back_button;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_image);

        back_button = findViewById(R.id.button2);
        imageView = findViewById(R.id.imageView);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            String message = extras.getString("SelectedRadioButton");

            if (message != null) {
                handleImageDisplay(message);
            } else {

            }
        } else {

        }

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DisplayImageActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void handleImageDisplay(String message) {
        switch (message) {
            case "drawable":
                imageView.setImageResource(R.drawable.mcqueen);
                break;
            case "sdcard":
                String fileName = "/sdcard/images/StripWeathersCars.png";
                Bitmap bitmap = BitmapFactory.decodeFile(fileName);
                imageView.setImageBitmap(bitmap);
                break;
            default:
                break;
        }
    }
}
