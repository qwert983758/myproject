package com.example.myapplication.activity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.base.Util;
import com.example.myapplication.moudel.YoufengModel;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * 添加设备界面
 */
public class YoufengAddActivity extends BaseActivity implements View.OnClickListener {
    private Button mBackBt;
    private Button mWriteBt;
    private EditText mNameEt;
    private EditText mWithEt;
    private EditText mHeightEt;
    private EditText mLengthEt;
    private EditText mPriceEt;
    private EditText mNumEt;
    private EditText mLocationEt;
    private EditText mBeApplicableEt;
    private EditText mSummaryEt;

    private YoufengModel mYoufengModel;

    private TextView mDeleteTv;


    @Override
    protected void initView() {
        setContentView(R.layout.activity_youfeng_add);
        mBackBt = findViewById(R.id.back);
        mBackBt.setOnClickListener(this);
        mWriteBt = findViewById(R.id.write);
        mWriteBt.setVisibility(View.VISIBLE);
        mWriteBt.setOnClickListener(this);
        mWriteBt.setText("保存");

        mNameEt = findViewById(R.id.name);
        mWithEt = findViewById(R.id.with);
        mHeightEt = findViewById(R.id.height);
        mLengthEt = findViewById(R.id.leight);
        mPriceEt = findViewById(R.id.price);
        mNumEt = findViewById(R.id.num);
        mLocationEt = findViewById(R.id.location);
        mBeApplicableEt = findViewById(R.id.be_applicable);
        mSummaryEt = findViewById(R.id.more);
        mDeleteTv = findViewById(R.id.delete);
    }

    @Override
    protected void initData() {
        TextView titleTv = findViewById(R.id.title_tv);
        titleTv.setText("添加油封");
        // 查看设备信息
        if ("true".equals(getIntent().getStringExtra("device_information"))) {
            String with = getIntent().getStringExtra("device_with");
            String height = getIntent().getStringExtra("device_height");
            String length = getIntent().getStringExtra("device_length");
            qury(with, height, length);
            mDeleteTv.setOnClickListener(this);
        } else {
            mDeleteTv.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                YoufengAddActivity.this.finish();
                break;
            case R.id.write:
                addData();
                break;
            case R.id.delete:
                delete();
                break;
            default:
                break;
        }
    }

    private void addData() {
        if (Util.isEmpty(mWithEt.getText().toString())) {
            Toast.makeText(YoufengAddActivity.this, "请输入宽", Toast.LENGTH_SHORT).show();
            return;
        }
        if (Util.isEmpty(mHeightEt.getText().toString())) {
            Toast.makeText(YoufengAddActivity.this, "请输入高", Toast.LENGTH_SHORT).show();
            return;
        }
        if (Util.isEmpty(mLengthEt.getText().toString())) {
            Toast.makeText(YoufengAddActivity.this, "请输入长", Toast.LENGTH_SHORT).show();
            return;
        }
        if (Util.isEmpty(mPriceEt.getText().toString())) {
            Toast.makeText(YoufengAddActivity.this, "请输入价格", Toast.LENGTH_SHORT).show();
            return;
        }
        if (Util.isEmpty(mLocationEt.getText().toString())) {
            Toast.makeText(YoufengAddActivity.this, "请输入位置", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!"true".equals(getIntent().getStringExtra("device_information")))
            mYoufengModel = new YoufengModel();
        mYoufengModel.setModelWith(mWithEt.getText().toString());
        mYoufengModel.setModelHeight(mHeightEt.getText().toString());
        mYoufengModel.setModelLength(mLengthEt.getText().toString());
        mYoufengModel.setPrice(Double.parseDouble(mPriceEt.getText().toString()));
        mYoufengModel.setLocation(mLocationEt.getText().toString());
        mYoufengModel.setNum(Integer.parseInt(mNumEt.getText().toString()));
        mYoufengModel.setBeApplicable(mBeApplicableEt.getText().toString());
        mYoufengModel.setSummary(mSummaryEt.getText().toString());
        mYoufengModel.save();
        YoufengAddActivity.this.finish();
    }


    private void delete() {
        if (mYoufengModel != null) {
            mYoufengModel.delete();
            YoufengAddActivity.this.finish();
        }
    }

    private void qury(String with, String height, String length) {
        List<YoufengModel> youfengModels = DataSupport.where("mModelWith = ? and mModelHeight = ? and mModelLength = ?", with, height, length).find(YoufengModel.class);
        for (int i = 0; i < youfengModels.size(); i++) {
            mYoufengModel = youfengModels.get(i);
        }
        if (mYoufengModel != null) {
            setViewData();
        }

    }

    private void setViewData() {
        mNameEt.setText(mYoufengModel.getModelWith() + "" + mYoufengModel.getModelHeight() + "" + mYoufengModel.getModelLength());
        mWithEt.setText(mYoufengModel.getModelWith());
        mLengthEt.setText(mYoufengModel.getModelLength());
        mHeightEt.setText(mYoufengModel.getModelHeight());
        mPriceEt.setText(mYoufengModel.getPrice() + "");
        mLocationEt.setText(mYoufengModel.getLocation());
        mNumEt.setText(mYoufengModel.getNum() + "");
        mBeApplicableEt.setText(mYoufengModel.getBeApplicable());
        mSummaryEt.setText(mYoufengModel.getSummary());
    }


}
