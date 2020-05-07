package com.whilerain.animationpractices.lesson5;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.whilerain.animationpractices.R;

public class Lesson5YoutubeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.motion_24_youtube);
        MotionLayout motionLayout = findViewById(R.id.motionLayout);
        RecyclerView recyclerView = findViewById(R.id.recyclerview_front);
        recyclerView.setAdapter(new PhotosAdapter());
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(Lesson5YoutubeActivity.this));

        motionLayout.setDebugMode(MotionLayout.DEBUG_SHOW_PATH);
    }
}
