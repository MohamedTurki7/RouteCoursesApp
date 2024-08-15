package com.example.routecourseapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class HomeActivity extends AppCompatActivity {
    MaterialButton androidButton;
    MaterialButton iosButton;
    MaterialButton fullStackButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(v.getPaddingLeft(), systemBars.top, v.getPaddingRight(), systemBars.bottom);
            return insets;
        });
        findButtons();
        setOnClickListener();
    }

    private void setOnClickListener() {
        androidButton.setOnClickListener(view -> startCourseActivity(R.drawable.android, R.string.android_content));
        iosButton.setOnClickListener(view -> startCourseActivity(R.drawable.ios, R.string.ios_content));
        fullStackButton.setOnClickListener(view -> startCourseActivity(R.drawable.fullstack, R.string.fullstack_content));

    }

    private void findButtons() {
        androidButton = findViewById(R.id.android_but);
        iosButton = findViewById(R.id.ios_but);
        fullStackButton = findViewById(R.id.fullStack_but);


    }

    private void startCourseActivity(int courseImgId, int courseContentId) {
        Intent intent = new Intent(this, CourseActivity.class);
        intent.putExtra("courseImg", courseImgId);
        intent.putExtra("courseContent", courseContentId);

        startActivity(intent);
    }
}