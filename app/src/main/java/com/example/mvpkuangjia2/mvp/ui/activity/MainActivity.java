package com.example.mvpkuangjia2.mvp.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mvpkuangjia2.R;
import com.example.mvpkuangjia2.app.bean.TabEntity;
import com.example.mvpkuangjia2.app.eventBus.GengDuoEvent;
import com.example.mvpkuangjia2.app.utils.AppUtil;
import com.example.mvpkuangjia2.di.component.DaggerMainComponent;
import com.example.mvpkuangjia2.mvp.contract.MainContract;
import com.example.mvpkuangjia2.mvp.presenter.MainPresenter;
import com.example.mvpkuangjia2.mvp.ui.fragment.MineFragment;
import com.example.mvpkuangjia2.mvp.ui.fragment.ShouYeFragment;
import com.example.mvpkuangjia2.mvp.ui.fragment.XinYongGongShiFragment;
import com.example.mvpkuangjia2.mvp.ui.fragment.XinYongZiXunFragment;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;
import com.tbruyelle.rxpermissions2.RxPermissions;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 08/16/2019 09:42
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    //FrameLayout
    @BindView(R.id.fl_change)
    FrameLayout fl_change;
    //刷新
    @BindView(R.id.tabLayout)
    CommonTabLayout tabLayout;

    private String[] mTitles = {"首页", "信用资讯", "信用公示", "更多"};
    private int[] mIconUnselectIds = {
            R.mipmap.hshouye, R.mipmap.hzixun,
            R.mipmap.hxingygs, R.mipmap.hmine};
    private int[] mIconSelectIds = {
            R.mipmap.hshouye1, R.mipmap.hzixun1,
            R.mipmap.hxingygs1, R.mipmap.hmine1};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private ShouYeFragment shouYeFragment;
    private XinYongZiXunFragment xinYongZiXunFragment;
    private XinYongGongShiFragment xinYongGongShiFragment;
    private MineFragment mineFragment;
    @Inject
    RxPermissions mRxPermissions;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerMainComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_main; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        shouYeFragment = new ShouYeFragment();
        xinYongZiXunFragment = new XinYongZiXunFragment();
        xinYongGongShiFragment = new XinYongGongShiFragment();
        mineFragment = new MineFragment();
        mFragments.clear();
        mTabEntities.clear();
        mFragments.add(shouYeFragment);
        mFragments.add(xinYongZiXunFragment);
        mFragments.add(xinYongGongShiFragment);
        mFragments.add(mineFragment);
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        tabLayout.setTabData(mTabEntities, this, R.id.fl_change, mFragments);
        tabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                if(position==3){
                    AppUtil.isLogin1(MainActivity.this);
                }
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        mPresenter.requestPermission();
    }

    //点击首页更多跳转信用资讯页面
    @Subscribe
    public void onEventMainThread(GengDuoEvent event) {
        tabLayout.setCurrentTab(1);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ArmsUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        ArmsUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.mRxPermissions = null;
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public RxPermissions getRxPermissions() {
        return mRxPermissions;
    }
}
