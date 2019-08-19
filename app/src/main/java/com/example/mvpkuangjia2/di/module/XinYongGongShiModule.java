package com.example.mvpkuangjia2.di.module;

import com.jess.arms.di.scope.FragmentScope;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

import com.example.mvpkuangjia2.mvp.contract.XinYongGongShiContract;
import com.example.mvpkuangjia2.mvp.model.XinYongGongShiModel;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 08/16/2019 18:44
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@Module
public abstract class XinYongGongShiModule {

    @Binds
    abstract XinYongGongShiContract.Model bindXinYongGongShiModel(XinYongGongShiModel model);
}