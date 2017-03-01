package com.jxn.androidwidgetlearn.drawer;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.jxn.androidwidgetlearn.R;

/**
 * Created by jnq on 2017/3/1.
 */

public class DrawerLayoutActivity extends FragmentActivity implements AdapterView.OnItemClickListener{

    DrawerLayout mDrawerLayout;
    ListView mMenuList;
    FrameLayout mContentFrame;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_layout);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mMenuList = (ListView) findViewById(R.id.left_drawer);
        mContentFrame = (FrameLayout) findViewById(R.id.content_frame);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                new String[]{"menu1", "menu2", "menu3", "menu4"});
        mMenuList.setAdapter(adapter);
        mMenuList.setOnItemClickListener(this);

        getSupportFragmentManager().beginTransaction().add(R.id.content_frame, new ContentFragment()).commit();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
