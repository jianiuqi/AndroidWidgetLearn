package com.jxn.androidwidgetlearn.onActivityResult;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

import com.jxn.androidwidgetlearn.R;

/**
 * Created by jnq on 2017/2/28.
 * 1、ResultActivity中嵌套着FragmentA，FragmentA中嵌套着FragmentB
 * 2、FragmentB中用startAcvitityForResult，看是否FragmentB能否收到onActivityResult
 */

public class ResultActivityB extends FragmentActivity {

    TextView mTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_container);
        mTitle = (TextView) findViewById(R.id.custom_title);
        mTitle.setText("ActivityB 点击返回结果");
        mTitle.setBackgroundColor(Color.GRAY);
        mTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });
    }
}
