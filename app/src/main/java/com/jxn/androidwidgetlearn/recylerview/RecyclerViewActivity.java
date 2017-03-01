package com.jxn.androidwidgetlearn.recylerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jxn.androidwidgetlearn.R;
import com.jxn.androidwidgetlearn.layoutWeight.LayoutWeightActivity;
import com.jxn.androidwidgetlearn.onActivityResult.ResultActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * RecylerView的使用方法
 * 1.添加依赖app build.gradle中加入compile 'com.android.support:recyclerview-v7:25.1.1'
 * 2.在xml中添加android.support.v7.widget.RecyclerView
 * 3.初始化
 */
public class RecyclerViewActivity extends AppCompatActivity implements RecyclerDemoAdapter.OnItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        List<String> dataList = new ArrayList<>();
        dataList.add("Fragment两层嵌套onActivityResult分发");
        dataList.add("layout_weight属性实践");
        dataList.add("DrawerLayout应用");
        dataList.add("ListView应用");
        dataList.add("Tab加载数据提高效率");
        dataList.add("for循环时插入删除数据");
        for(int i=0; i<30; i++){
            dataList.add("Widget" + i);
        }

        /**1.创建对象 */
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        /**2.设置显示规则
         * RecyclerView 将所有的显示规则交给一个叫 LayoutManager 的类去完成了。
         * LayoutManager 是一个抽象类，系统已经为我们提供了三个默认的实现类，分别是 LinearLayoutManager 、
         * GridLayoutManager 、 StaggeredGridLayoutManager，
         * 从名字我们就能看出来了，分别是，线性显示、网格显示、瀑布流显示。
         * 当然你也可以通过继承这些类来扩展实现自己的 LayougManager。
         * staggered  错列的，叉排的  美 [ˈstægərd]
         */
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        //recyclerView.setLayoutManager(new StaggeredGridLayoutManager(5, StaggeredGridLayoutManager.VERTICAL));
        /** 3.设置适配器
         *  创建适配器 继承RecyclerView.Adapter<VH>类，实现三个抽象方法onCreateViewHolder、onBindViewHolder、getItemCount
         *  创建一个静态的 ViewHolder
         *  泛型中的类名应该是这个holder的类名)；并且 ViewHolder 必须继承自RecyclerView.ViewHolder类
         */
        RecyclerDemoAdapter adapter = new RecyclerDemoAdapter(this, dataList);
        recyclerView.setAdapter(adapter);
        /** 设置Item增加移除动画*/
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        /** 添加分割线*/
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        //recyclerView.addItemDecoration(new DividerGridItemDecoration(this));
        adapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(View view, int position) {
        switch (position) {
            case 0:
                startActivity(new Intent(this, ResultActivity.class));
                break;
            case 1:
                startActivity(new Intent(this, LayoutWeightActivity.class));
                break;
        }
    }
}
