package com.whilerain.animationpractices.lesson1;import android.animation.AnimatorInflater;import android.animation.AnimatorSet;import android.animation.ObjectAnimator;import android.os.Bundle;import androidx.appcompat.app.AppCompatActivity;import android.view.View;import android.view.animation.Animation;import android.view.animation.AnimationUtils;import com.whilerain.animationpractices.R;public class Lesson1Activity extends AppCompatActivity {    @Override    protected void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        setContentView(R.layout.activity_lesson1);        View view = findViewById(R.id.text);        view.setOnClickListener(new View.OnClickListener() {            @Override            public void onClick(View v) {                // Do property animation programatically                ObjectAnimator.ofFloat(v, "scaleX", 1.5f)                        .setDuration(500)                        .start();                ObjectAnimator.ofFloat(v, "scaleY", 1.5f)                        .setDuration(500)                        .start();                // launch a property animation with xml//                AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(Lesson1Activity.this, R.animator.property_scale_size);//                set.setTarget(v);//                set.start();                // launch a view animation//                Animation anim = AnimationUtils.loadAnimation(Lesson1Activity.this, R.anim.tween_slide_in_from_buttom);//                v.startAnimation(anim);            }        });    }    /**     * Property animation can be launch programmatically     *     * @param view     */    public void rotateyAnimRun(View view) {        ObjectAnimator                .ofFloat(view, "rotationX", 0.0F, 360.0F)                .setDuration(500)                .start();    }}