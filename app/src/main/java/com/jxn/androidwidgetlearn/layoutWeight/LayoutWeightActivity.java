package com.jxn.androidwidgetlearn.layoutWeight;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jxn.androidwidgetlearn.R;

/**
 * Created by jnq on 2017/2/28.
 */

public class LayoutWeightActivity extends AppCompatActivity implements View.OnClickListener{

    LinearLayout mLayout1;
    LinearLayout mLayout2;
    LinearLayout mLayout3;
    LinearLayout mLayout4;
    TextView mTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_weight);
        mLayout1 = (LinearLayout) findViewById(R.id.linear_layout_1);
        mLayout2 = (LinearLayout) findViewById(R.id.linear_layout_2);
        mLayout3 = (LinearLayout) findViewById(R.id.linear_layout_3);
        mLayout4 = (LinearLayout) findViewById(R.id.linear_layout_4);
        mTextView = (TextView) findViewById(R.id.widget_size);
        mLayout1.setOnClickListener(this);
        mLayout2.setOnClickListener(this);
        mLayout3.setOnClickListener(this);
        mLayout4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.linear_layout_1:
                showSize(mLayout1, "Layout1中的TextView都为0dp：\n");
                break;
            case R.id.linear_layout_2:
                showSize(mLayout2, "Layout2中的TextView都为match_parent：\n");
                break;
            case R.id.linear_layout_3:
                showSize(mLayout3, "Layout3中的TextView第一个为wrap_content,其他的为match_parent：\n");
                break;
            case R.id.linear_layout_4:
                showSize(mLayout4, "Layout4中的TextView第一个为layout_weight为1,总的weightSum为6：\n");
                break;
        }
    }

    /**
     * LinearLayout中layout_weight分配规则：
     * 1、先按照控件声明的尺寸进行分配
     * 2、再将剩下的尺寸按weight分配
     * 3、控件宽度 = 声明宽度 + 屏幕剩余宽度*权重比
     * @param layout
     * @param text
     */
    private void showSize(LinearLayout layout, String text) {
        int childCount = layout.getChildCount();
        StringBuilder stringBuilder = new StringBuilder();
        /**在调用oncreate()方法时，界面处于不可见状态，内存加载组件还没有绘制出来，你是无法获取他的尺寸。*/
        stringBuilder.append(text).append("Layout宽度为：")
                .append(layout.getWidth()).append("\n");
        for (int i = 0; i < childCount; i++) {
            View view = layout.getChildAt(i);
            stringBuilder.append("view").append(i).
                    append("宽度：").append(view.getWidth()).append("\n");
        }
        mTextView.setText(stringBuilder.toString());
    }
}
