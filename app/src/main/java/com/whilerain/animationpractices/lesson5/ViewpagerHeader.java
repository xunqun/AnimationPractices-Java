/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.whilerain.animationpractices.lesson5;


import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.viewpager.widget.ViewPager;

class ViewpagerHeader extends MotionLayout implements ViewPager.OnPageChangeListener{

    public ViewpagerHeader(Context context) {
        super(context);
    }

    public ViewpagerHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewpagerHeader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        int numPages = 3;
        setProgress( (position + positionOffset) / (numPages - 1));
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}