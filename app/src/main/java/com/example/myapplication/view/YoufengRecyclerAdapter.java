package com.example.myapplication.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.moudel.YoufengModel;

import java.util.List;

/**
 * 油封列表界面
 */
public class YoufengRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<YoufengModel> mList;
    private View mInflater;
    private onItemClickListener mOnClick;
    public void setContext(Context context) {
        mContext = context;
    }

    public void setList(List list) {
        mList = list;
    }

    public void setOnClick(onItemClickListener onClick){
        mOnClick = onClick;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mInflater = LayoutInflater.from(mContext).inflate(R.layout.adapter_youfeng_list, null);
        YoufengHolder youfengHolder = new YoufengHolder(mInflater);

        return youfengHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        YoufengHolder youfengHolder = (YoufengHolder) holder;
        youfengHolder.mDeviceStyle.setText(mList.get(position).getModelWith() + "*" + mList.get(position).getModelLength() + "*" + mList.get(position).getModelHeight());
        youfengHolder.mDeviceNum.setText(mList.get(position).getNum()+"");
        int _position  = position;
        youfengHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnClick.onItemClick(_position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class YoufengHolder extends RecyclerView.ViewHolder {
        public TextView mDeviceName;
        public TextView mDeviceStyle;
        public TextView mDeviceNum;

        public YoufengHolder(View itemView) {
            super(itemView);
            mDeviceName = itemView.findViewById(R.id.device_name);
            mDeviceStyle = itemView.findViewById(R.id.device_styple);
            mDeviceNum = itemView.findViewById(R.id.device_num);
        }
    }

    public interface onItemClickListener{
        void onItemClick(int position);
    }
}
