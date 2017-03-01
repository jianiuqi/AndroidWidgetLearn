package com.jxn.androidwidgetlearn.onActivityResult;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.TextView;

import com.jxn.androidwidgetlearn.R;
import com.jxn.androidwidgetlearn.base.Constant;

/**
 * Created by jnq on 2017/2/28.
 * 1、ResultActivity中嵌套着FragmentA，FragmentA中嵌套着FragmentB
 * 2、FragmentB中用startAcvitityForResult，看是否FragmentB能否收到onActivityResult
 */

public class ResultActivity extends FragmentActivity {

    TextView mTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_container);
        mTitle = (TextView) findViewById(R.id.custom_title);
        mTitle.setText("初始Activity");
        mTitle.setBackgroundColor(Color.RED);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, new FragmentA()).commit();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        /** 这句话为重点，当没有这句话是不会传递到内层的Fragment中*/
        super.onActivityResult(requestCode, resultCode, data);
        Log.i(Constant.TAG, "ResultActivity onActivityResult：" + resultCode);
    }
}
