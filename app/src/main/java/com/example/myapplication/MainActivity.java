package com.example.myapplication;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.activity.YoufengListActivity;
import com.example.myapplication.base.BaseActivity;


public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button mBack;

    private TextView mTitleTv;

    private TextView mYoufeng;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_main);
        mBack = findViewById(R.id.back);
        mTitleTv = findViewById(R.id.title_tv);
        mTitleTv.setText("主界面");
        mYoufeng = findViewById(R.id.youfeng);
        mBack.setOnClickListener(this);
        mYoufeng.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                MainActivity.this.finish();
                break;
            case R.id.youfeng:
                Intent _intent = new Intent(MainActivity.this, YoufengListActivity.class);
                MainActivity.this.startActivity(_intent);
                break;
            default:
                break;
        }
    }
}