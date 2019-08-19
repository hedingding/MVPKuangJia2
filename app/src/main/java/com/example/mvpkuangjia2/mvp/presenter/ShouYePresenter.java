package com.example.mvpkuangjia2.mvp.presenter;

import android.app.Application;

import com.example.mvpkuangjia2.app.bean.HomeImgInfo;
import com.example.mvpkuangjia2.app.netRequest.NetWorkManager;
import com.jess.arms.integration.AppManager;
import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.http.imageloader.ImageLoader;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

import javax.inject.Inject;

import com.example.mvpkuangjia2.mvp.contract.ShouYeContract;


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
@FragmentScope
public class ShouYePresenter extends BasePresenter<ShouYeContract.Model, ShouYeContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;

    @Inject
    public ShouYePresenter(ShouYeContract.Model model, ShouYeContract.View rootView) {
        super(model, rootView);
    }
    //图片轮播列表
    public void requestTuPianLunBo() {
        NetWorkManager
                .getInstance()
                .getOneApiService()
                .getTuPianLunBo()
                .compose(NetWorkManager.getInstance().getDefaultTransformer())
                .subscribe(new Observer<HomeImgInfo>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HomeImgInfo response) {
                        mRootView.TuPianLunBoList(response.getData());
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
    //运营图列表
    public void requestYunYingTu() {
        NetWorkManager
                .getInstance()
                .getOneApiService()
                .getYunYingTu()
                .compose(NetWorkManager.getInstance().getDefaultTransformer())
                .subscribe(new Observer<HomeImgInfo>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HomeImgInfo response) {
                        mRootView.YunYingTuList(response.getData());
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
