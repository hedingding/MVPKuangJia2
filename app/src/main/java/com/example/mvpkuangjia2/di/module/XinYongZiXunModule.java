package com.example.mvpkuangjia2.di.module;

import com.jess.arms.di.scope.FragmentScope;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

import com.example.mvpkuangjia2.mvp.contract.XinYongZiXunContract;
import com.example.mvpkuangjia2.mvp.model.XinYongZiXunModel;


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
@Module
public abstract class XinYongZiXunModule {

    @Binds
    abstract XinYongZiXunContract.Model bindXinYongZiXunModel(XinYongZiXunModel model);
}