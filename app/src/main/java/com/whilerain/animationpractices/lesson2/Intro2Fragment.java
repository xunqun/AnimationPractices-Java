package com.whilerain.animationpractices.lesson2;import android.os.Bundle;import android.support.annotation.NonNull;import android.support.annotation.Nullable;import android.support.v4.app.Fragment;import android.view.LayoutInflater;import android.view.View;import android.view.ViewGroup;import com.whilerain.animationpractices.R;public class Intro2Fragment extends Fragment {    @Nullable    @Override    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {        View view = inflater.inflate(R.layout.fragment_intro2, container, false);        view.setTag(getClass().getSimpleName());        return view;    }}