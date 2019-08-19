package com.example.mvpkuangjia2.mvp.ui.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvpkuangjia2.app.bean.User;
import com.example.mvpkuangjia2.app.utils.DividerItemDecoration;
import com.example.mvpkuangjia2.mvp.ui.adapter.HomeXinYongChaXunAdapter;
import com.example.mvpkuangjia2.mvp.ui.adapter.XinYongDongTaiAdapter1;
import com.jess.arms.base.BaseFragment;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.example.mvpkuangjia2.di.component.DaggerXinYongZiXunComponent;
import com.example.mvpkuangjia2.mvp.contract.XinYongZiXunContract;
import com.example.mvpkuangjia2.mvp.presenter.XinYongZiXunPresenter;

import com.example.mvpkuangjia2.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import butterknife.BindView;

import static com.jess.arms.utils.Preconditions.checkNotNull;



public class XinYongZiXunFragment extends BaseFragment<XinYongZiXunPresenter> implements XinYongZiXunContract.View {
    //刷新
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    //无数据显示无页面
    @BindView(R.id.ll_wu)
    LinearLayout ll_wu;
    //信用动态列表
    @BindView(R.id.lv_xinyongdongtai)
    RecyclerView lv_xinyongdongtai;
    //信用动态列表
    XinYongDongTaiAdapter1 xinYongDongTaiAdapter;

    public static XinYongZiXunFragment newInstance() {
        XinYongZiXunFragment fragment = new XinYongZiXunFragment();
        return fragment;
    }

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
        DaggerXinYongZiXunComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_xin_yong_zi_xun, container, false);
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        //信用动态列表
        LinearLayoutManager linear = new LinearLayoutManager(getActivity());
        lv_xinyongdongtai.setLayoutManager(linear);
        lv_xinyongdongtai.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL, Color.parseColor("#FFDDDDDD")));
        mPresenter.requestUserList(true);
        xinYongDongTaiAdapter = new XinYongDongTaiAdapter1(getActivity());
        lv_xinyongdongtai.setAdapter(xinYongDongTaiAdapter);
        shuaxin();
    }
    //刷新
    private void shuaxin() {
        //刷新
        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull final RefreshLayout refreshLayout) {
                refreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //刷新
                        mPresenter.requestUserList(true);
                        refreshLayout.finishRefresh();
                        refreshLayout.setNoMoreData(false);
                    }
                }, 1500);
            }
        });
        refresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull final RefreshLayout refreshLayout) {
                refreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //下拉加载
                        mPresenter.requestUserList(false);
                        refreshLayout.finishLoadMore();
                    }
                }, 1500);
            }
        });
    }

    //获得用户列表
    @Override
    public void getUserListSuccess(boolean pullToRefresh, List<User> list) {
        if (list.size() == 0) {
            if (pullToRefresh) {
                //无数据显示无界面
                ll_wu.setVisibility(View.VISIBLE);
                refresh.setVisibility(View.GONE);
            }else{
                //大于1页，无数据显示已是最后一页
                ArmsUtils.makeText(getActivity(), "已经是最后一页");
            }
        } else {
            //有数据加载数据
            ll_wu.setVisibility(View.GONE);
            refresh.setVisibility(View.VISIBLE);
            if (pullToRefresh) {
                xinYongDongTaiAdapter.getData().clear();
                xinYongDongTaiAdapter.addData(list);
                xinYongDongTaiAdapter.notifyDataSetChanged();
            } else {
                int preEndIndex = xinYongDongTaiAdapter.getData().size();
                xinYongDongTaiAdapter.addData(list);
                xinYongDongTaiAdapter.notifyItemRangeInserted(preEndIndex, list.size());
            }
        }
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
