package com.example.mvpkuangjia2.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.example.mvpkuangjia2.di.module.MainModule;
import com.example.mvpkuangjia2.mvp.contract.MainContract;
import com.example.mvpkuangjia2.mvp.ui.activity.MainActivity;
import com.jess.arms.di.component.AppComponent;


import com.jess.arms.di.scope.ActivityScope;


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
@ActivityScope
@Component(modules = MainModule.class, dependencies = AppComponent.class)
public interface MainComponent {
    void inject(MainActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder view(MainContract.View view);

        Builder appComponent(AppComponent appComponent);

        MainComponent build();
    }
}