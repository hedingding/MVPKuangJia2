/*
 * Copyright 2017 JessYan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.mvpkuangjia2.app.utils;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.mvpkuangjia2.app.dialog.MyChoiceDialog;
import com.example.mvpkuangjia2.app.web.WebActivity;
import com.example.mvpkuangjia2.mvp.ui.activity.MainActivity;
import com.jess.arms.utils.ArmsUtils;
import com.jess.arms.utils.DataHelper;


/**
 * ================================================
 * 一些框架常用的工具
 * <p>
 * Created by JessYan on 2015/11/23.
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
public class AppUtil {
    static public Toast mToast;

    private AppUtil() {
        throw new IllegalStateException("you can't instantiate me!");
    }

    //判断是否登录
    public static boolean isLogin(Context context) {
        //得到用户id

        String userId = DataHelper.getStringSF(context, SysCode.SHAREDPREFERENCES.USER_ID);
        //如果用户id为空，表示未登录；否则表示已登录
        if (TextUtils.isEmpty(userId)) {
            return false;
        }
        return true;
    }
    //判断是否登录弹框
    public static void isLogin1(Context context) {
        //得到用户id
        String userId = DataHelper.getStringSF(context, SysCode.SHAREDPREFERENCES.USER_ID);
        //如果用户id为空，表示未登录；否则表示已登录
        if (TextUtils.isEmpty(userId)) {
//            DataHelper.setStringSF(context, SysCode.SHAREDPREFERENCES.USER_ID, "");
            MyChoiceDialog mc = new MyChoiceDialog(context, "您尚未登录，请登录") {
                @Override
                public void onCancleClick() {

                }

                @Override
                public void onOkClick() {
//                    ArmsUtils.startActivity(LoginActivity.class);
                }
            };
            mc.show();
            mc.setCanceledOnTouchOutside(false);
        }
    }

    //点击跳转
    public static void startWebActivity(Context context, String url) {
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra("url", url);
        context.startActivity(intent);
    }
}
