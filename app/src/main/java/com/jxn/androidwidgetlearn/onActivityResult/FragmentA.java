package com.jxn.androidwidgetlearn.onActivityResult;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jxn.androidwidgetlearn.R;
import com.jxn.androidwidgetlearn.base.Constant;

/**
 * Created by jnq on 2017/2/28.
 */

public class FragmentA extends Fragment{

    TextView mTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_fragment_container, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTextView = (TextView) view.findViewById(R.id.custom_title);
        mTextView.setText("FragmentA");
        mTextView.setBackgroundColor(Color.GREEN);
        getChildFragmentManager().beginTransaction()
                .add(R.id.fragment_container, new FragmentB()).commit();
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ResultActivityB.class);
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i(Constant.TAG, "FragmentA onActivityResult：" + resultCode);
    }
}
