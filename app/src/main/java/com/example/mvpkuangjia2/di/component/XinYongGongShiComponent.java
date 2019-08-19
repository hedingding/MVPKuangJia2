package com.example.mvpkuangjia2.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.example.mvpkuangjia2.di.module.XinYongGongShiModule;
import com.example.mvpkuangjia2.mvp.contract.XinYongGongShiContract;

import com.jess.arms.di.scope.FragmentScope;
import com.example.mvpkuangjia2.mvp.ui.fragment.XinYongGongShiFragment;


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
@FragmentScope
@Component(modules = XinYongGongShiModule.class, dependencies = AppComponent.class)
public interface XinYongGongShiComponent {
    void inject(XinYongGongShiFragment fragment);

    @Component.Builder
    interface Builder {
        @BindsInstance
        XinYongGongShiComponent.Builder view(XinYongGongShiContract.View view);

        XinYongGongShiComponent.Builder appComponent(AppComponent appComponent);

        XinYongGongShiComponent build();
    }
}