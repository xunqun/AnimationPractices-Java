package com.whilerain.animationpractices.lesson2;import android.os.Bundle;import androidx.fragment.app.Fragment;import androidx.fragment.app.FragmentManager;import androidx.fragment.app.FragmentStatePagerAdapter;import androidx.viewpager.widget.ViewPager;import androidx.appcompat.app.AppCompatActivity;import com.whilerain.animationpractices.R;import java.util.ArrayList;import java.util.List;public class Lesson2Activity extends AppCompatActivity {    ViewPager pager;    @Override    protected void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        setContentView(R.layout.activity_lesson2);        pager = findViewById(R.id.pager);        pager.setAdapter(new IntroSlidePagerAdapter(getSupportFragmentManager()));        pager.setPageTransformer(false, new MyPageTransormer());    }    /**     * Adapter for the view pager     */    private class IntroSlidePagerAdapter extends FragmentStatePagerAdapter {        List<Fragment> intros = new ArrayList<>();        public IntroSlidePagerAdapter(FragmentManager fm) {            super(fm);            intros.add(new Intro1Fragment());            intros.add(new Intro2Fragment());            intros.add(new Intro3Fragment());            intros.add(new Intro4Fragment());            intros.add(new GrantGpsFragment());        }        @Override        public Fragment getItem(int i) {            return intros.get(i);        }        @Override        public int getCount() {            return intros.size();        }    }}