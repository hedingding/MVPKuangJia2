package com.example.mvpkuangjia2.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.example.mvpkuangjia2.di.module.ShouYeModule;
import com.example.mvpkuangjia2.mvp.contract.ShouYeContract;

import com.jess.arms.di.scope.FragmentScope;
import com.example.mvpkuangjia2.mvp.ui.fragment.ShouYeFragment;


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
@Component(modules = ShouYeModule.class, dependencies = AppComponent.class)
public interface ShouYeComponent {
    void inject(ShouYeFragment fragment);

    @Component.Builder
    interface Builder {
        @BindsInstance
        ShouYeComponent.Builder view(ShouYeContract.View view);

        ShouYeComponent.Builder appComponent(AppComponent appComponent);

        ShouYeComponent build();
    }
}