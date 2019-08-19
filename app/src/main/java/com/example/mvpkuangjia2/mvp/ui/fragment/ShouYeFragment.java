package com.example.mvpkuangjia2.mvp.ui.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvpkuangjia2.app.bean.HomeImgInfo;
import com.example.mvpkuangjia2.app.eventBus.GengDuoEvent;
import com.example.mvpkuangjia2.app.tupianlunbo.AdviseCycleView;
import com.example.mvpkuangjia2.app.utils.AppUtil;
import com.example.mvpkuangjia2.app.utils.DividerItemDecoration;
import com.example.mvpkuangjia2.mvp.ui.adapter.HomeXinYongChaXunAdapter;
import com.example.mvpkuangjia2.mvp.ui.adapter.XinYongDongTaiAdapter;
import com.jess.arms.base.BaseFragment;
import com.jess.arms.base.DefaultAdapter;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.example.mvpkuangjia2.di.component.DaggerShouYeComponent;
import com.example.mvpkuangjia2.mvp.contract.ShouYeContract;
import com.example.mvpkuangjia2.mvp.presenter.ShouYePresenter;

import com.example.mvpkuangjia2.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 08/16/2019 18:42
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class ShouYeFragment extends BaseFragment<ShouYePresenter> implements ShouYeContract.View {

    //刷新
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    //图片轮播列表
    @BindView(R.id.home_cycle_view)
    AdviseCycleView home_cycle_view;
    //更多
    @BindView(R.id.tv_gengduo)
    TextView tv_gengduo;
    //网页
    @BindView(R.id.web)
    Button web;
    //运营图列表
    @BindView(R.id.gv_xinYongChaXun)
    RecyclerView gv_xinYongChaXun;
    //信用动态列表
    @BindView(R.id.lv_xinYongDongTai)
    RecyclerView lv_xinYongDongTai;
    //运营图列表
    HomeXinYongChaXunAdapter xinYongChaXunAdapter;
    //信用动态列表
    XinYongDongTaiAdapter xinYongDongTaiAdapter;


    public static ShouYeFragment newInstance() {
        ShouYeFragment fragment = new ShouYeFragment();
        return fragment;
    }

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
        DaggerShouYeComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_shou_ye, container, false);
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        //点击更多按钮调整第二个Fragment
        tv_gengduo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new GengDuoEvent(1));
            }
        });
        //webWiew跳转网页
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppUtil.startWebActivity(getActivity(), "https://www.baidu.com/");
            }
        });
        //刷新
        shuaxin();
        //图片轮播
        Log.e("gyl","111111111111");
        mPresenter.requestTuPianLunBo();
        //运营图列表
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 3);
//        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//            @Override
//            public int getSpanSize(int position) {
//                return 1;
//            }
//        });
        gv_xinYongChaXun.setLayoutManager(manager);
        gv_xinYongChaXun.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.HORIZONTAL, Color.parseColor("#FFDDDDDD")));
        mPresenter.requestYunYingTu();
        //信用动态列表
        LinearLayoutManager linear = new LinearLayoutManager(getActivity());
        lv_xinYongDongTai.setLayoutManager(linear);
        lv_xinYongDongTai.addItemDecoration(new DividerItemDecoration(getActivity(),LinearLayoutManager.VERTICAL, Color.parseColor("#FFDDDDDD")));
//        mPresenter.requestYunYingTu();
    }

    //刷新
    private void shuaxin() {
        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull final RefreshLayout refreshLayout) {
                refreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //图片轮播
                        mPresenter.requestTuPianLunBo();
                        refreshLayout.finishRefresh();
                        refreshLayout.setNoMoreData(false);
                    }
                }, 1500);
            }
        });
    }

    //图片轮播
    @Override
    public void TuPianLunBoList(List<HomeImgInfo.DataBean> list) {
        home_cycle_view.setData(list, new AdviseCycleView.OnAdviseClickListener() {
            @Override
            public void onClick(int position, View view) {
                if (!TextUtils.isEmpty(list.get(position).getName())) {
//                    Tools.startWebActivity(getActivity(), homeImageList.get(position).getRedirectUrl());
                }
            }
        });
    }

    //运营图列表
    @Override
    public void YunYingTuList(List<HomeImgInfo.DataBean> list) {
        xinYongChaXunAdapter = new HomeXinYongChaXunAdapter(getActivity(),list);
        gv_xinYongChaXun.setAdapter(xinYongChaXunAdapter);

        xinYongDongTaiAdapter = new XinYongDongTaiAdapter(getActivity(),list);
        lv_xinYongDongTai.setAdapter(xinYongDongTaiAdapter);
    }

    @Override
    public void onDestroy() {
        DefaultAdapter.releaseAllHolder(gv_xinYongChaXun);
        DefaultAdapter.releaseAllHolder(lv_xinYongDongTai);
        super.onDestroy();
        this.xinYongChaXunAdapter = null;
        this.xinYongDongTaiAdapter = null;
    }

    @Override
    public void setData(@Nullable Object data) {

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

    }
}
