package com.example.mvpkuangjia2.mvp.presenter;

import android.app.Application;

import com.example.mvpkuangjia2.app.bean.HomeImgInfo;
import com.example.mvpkuangjia2.app.bean.User;
import com.example.mvpkuangjia2.app.netRequest.NetWorkManager;
import com.example.mvpkuangjia2.app.netRequest.NetWorkManager1;
import com.jess.arms.integration.AppManager;
import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.http.imageloader.ImageLoader;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

import javax.inject.Inject;

import com.example.mvpkuangjia2.mvp.contract.XinYongZiXunContract;

import java.util.List;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 08/16/2019 18:43
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@FragmentScope
public class XinYongZiXunPresenter extends BasePresenter<XinYongZiXunContract.Model, XinYongZiXunContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;

    private int lastUserId = 1;
    private boolean isFirst = true;

    @Inject
    public XinYongZiXunPresenter(XinYongZiXunContract.Model model, XinYongZiXunContract.View rootView) {
        super(model, rootView);
    }

    //图片轮播列表
    public void requestUserList(boolean pullToRefresh) {
        if (pullToRefresh) lastUserId = 1;//下拉刷新默认只请求第一页
        NetWorkManager1
                .getInstance()
                .getOneApiService()
                .getUsers(lastUserId,10)
                .compose(NetWorkManager.getInstance().getDefaultTransformer())
                .subscribe(new Observer<List<User>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<User> users) {
                        lastUserId = users.get(users.size() - 1).getId();//记录最后一个id,用于下一次请求
                        mRootView.getUserListSuccess(pullToRefresh,users);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        String a=throwable.getMessage();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mErrorHandler = null;
        this.mAppManager = null;
        this.mImageLoader = null;
        this.mApplication = null;
    }
}
