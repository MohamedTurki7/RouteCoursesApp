package com.example.routecourseapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CourseActivity extends AppCompatActivity {
    TextView courseContent;
    ImageView courseImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_course);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(v.getPaddingLeft(), systemBars.top, v.getPaddingRight(), systemBars.bottom);
            return insets;
        });
        findViews();
        bindCourseData();
    }

    private void findViews() {
        courseImage = findViewById(R.id.content_img);
        courseContent = findViewById(R.id.tv_course_content);
    }

    private void bindCourseData() {
        Intent startIntent = getIntent();
        int courseImageId = startIntent.getIntExtra("courseImg", -1);
        int courseContentId = startIntent.getIntExtra("courseContent", -1);
        courseImage.setImageResource(courseImageId);
        courseContent.setText(courseContentId);


    }
}