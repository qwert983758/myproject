package com.example.myapplication.activity;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.moudel.YoufengModel;
import com.example.myapplication.view.YoufengRecyclerAdapter;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;
import org.litepal.util.Const;

import java.util.List;

/**
 * 油封列表显示界面
 */
public class YoufengListActivity extends BaseActivity implements View.OnClickListener {
    private Button mBackBt;
    private TextView mTitleTv;
    private RecyclerView mRecyclerView;
    private YoufengRecyclerAdapter mAdapter;
    private List<YoufengModel> mList;
    private Button mWriteBt;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_youfeng_list);
        mRecyclerView = findViewById(R.id.recyclerview);
        mBackBt = findViewById(R.id.back);
        mTitleTv = findViewById(R.id.title_tv);
        mTitleTv.setText("油封列表");
        mBackBt.setOnClickListener(this);
        mWriteBt = findViewById(R.id.write);
        mWriteBt.setVisibility(View.VISIBLE);
        mWriteBt.setText("添加");
        mWriteBt.setOnClickListener(this);

    }

    @Override
    protected void initData() {
        Connector.getDatabase();
        findDatas();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new YoufengRecyclerAdapter();
        mAdapter.setContext(YoufengListActivity.this);
        mAdapter.setList(mList);
        mAdapter.setOnClick(new YoufengRecyclerAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                jumpInformationActivity(position);
            }
        });
        mRecyclerView.setAdapter(mAdapter);
    }

    /**
     * 查询所有数据
     */
    private void findDatas() {
        mList = DataSupport.findAll(YoufengModel.class);
    }

    /**
     * 跳转到设备详情界面
     *
     * @param position
     */
    private void jumpInformationActivity(int position) {
        Intent _intent = new Intent(YoufengListActivity.this, YoufengAddActivity.class);
        _intent.putExtra("device_with", mList.get(position).getModelWith());
        _intent.putExtra("device_height", mList.get(position).getModelHeight());
        _intent.putExtra("device_length", mList.get(position).getModelLength());
        _intent.putExtra("device_information", "true");
        YoufengListActivity.this.startActivity(_intent);
    }

    /**
     * 跳转到添加界面
     */
    private void jumpAddActivity() {
        Intent _intent = new Intent(YoufengListActivity.this, YoufengAddActivity.class);
        _intent.putExtra("device_information", "false");
        YoufengListActivity.this.startActivity(_intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                YoufengListActivity.this.finish();
                break;
            case R.id.write:
                jumpAddActivity();
                break;
            default:
                break;
        }
    }
}
