package com.jxn.androidwidgetlearn.drawer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jxn.androidwidgetlearn.R;

/**
 * Created by jnq on 2017/3/1.
 */

public class ContentFragment extends Fragment {

    TextView mTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_drawer_fragment, container, false);
        mTextView = (TextView) view.findViewById(R.id.textview);
        if (getArguments() != null) {
            String text = getArguments().getString("text");
            mTextView.setText(text);
        }
        return view;
    }
}
