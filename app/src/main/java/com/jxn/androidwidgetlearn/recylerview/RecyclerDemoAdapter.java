package com.jxn.androidwidgetlearn.recylerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.jxn.androidwidgetlearn.R;

import java.util.List;

/**
 * Created by jnq on 2017/2/24.
 */

public class RecyclerDemoAdapter extends RecyclerView.Adapter<RecyclerDemoAdapter.VH> {

    private List<String> mDataList;

    private Context mContext;

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public  RecyclerDemoAdapter(Context context, List<String> datalist){
        this.mContext = context;
        this.mDataList = datalist;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i("LearnTag", "onCreateViewHolder()" + viewType);
        View view = LayoutInflater.from(mContext).inflate(R.layout.recyclerview_item, parent, false);
        final VH vh = new VH(view, mOnItemClickListener);
        return vh;
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        Log.i("LearnTag", "onBindViewHolder()" + position);
        holder.mTextView.setText(mDataList.get(position));
    }

    @Override
    public int getItemCount() {
        Log.i("LearnTag", "getItemCount()" + mDataList.size());
        return mDataList.size();
    }

    static class VH extends  RecyclerView.ViewHolder implements View.OnClickListener{

        TextView mTextView;
        OnItemClickListener mOnItemClickListener;

        public VH(View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);
            Log.i("LearnTag", "VH(View itemView)");
            mTextView = (TextView) itemView.findViewById(R.id.item_text);
            this.mOnItemClickListener = onItemClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(v, getAdapterPosition());
            }
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
}
