package com.jxn.androidwidgetlearn.onActivityResult;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jxn.androidwidgetlearn.R;
import com.jxn.androidwidgetlearn.base.Constant;

/**
 * Created by jnq on 2017/2/28.
 * 
 */

public class LifeCircleFragment extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(Constant.TAG, "onAttach()");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(Constant.TAG, "onCreate()");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(Constant.TAG, "onCreateView()");
        return inflater.inflate(R.layout.activity_fragment_container, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(Constant.TAG, "onViewCreated()");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(Constant.TAG, "onActivityCreated()");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(Constant.TAG, "onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(Constant.TAG, "onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(Constant.TAG, "onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(Constant.TAG, "onStop()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(Constant.TAG, "onDestroy()");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i(Constant.TAG, "onActivityResult()");
    }

}
