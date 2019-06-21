package com.itcunkou.commondemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.launcher.ARouter;
import com.itcunkou.commondemo.base.BaseActivity;
import com.itcunkou.commondemo.base.BaseContract;
import com.itcunkou.commondemo.base.BasePresenter;
import com.itcunkou.commondemo.common.ActivityContracts;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    @BindView(R.id.btn)
    Button mBtn;

    @Override
    protected void initView() {

    }

    @Override
    protected BaseContract.BasePresenter initPresenter() {
        return new BasePresenter();
    }

    @Override
    protected int getActivityLayoutID() {
        return R.layout.activity_main;
    }




    @OnClick(R.id.btn)
    public void onViewClicked() {
        ARouter.getInstance()
                .build(ActivityContracts.ACTIVITY_BOOK)
                .navigation();
    }
}
