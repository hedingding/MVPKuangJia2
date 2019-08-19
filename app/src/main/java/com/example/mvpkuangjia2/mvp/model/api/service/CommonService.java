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
package com.example.mvpkuangjia2.mvp.model.api.service;


import com.example.mvpkuangjia2.app.bean.HomeImgInfo;
import com.example.mvpkuangjia2.app.bean.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * ================================================
 * 存放通用的一些 API
 * <p>
 * Created by JessYan on 08/05/2016 12:05
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
public interface CommonService {
//    String APP_DOMAIN = "http://hc.hcsxj.cn";
    //图片轮播列表
    @GET("/sindex/getbanner")
    Observable<HomeImgInfo> getTuPianLunBo();

   //运营图列表
    @GET("/sindex/getbanner")
    Observable<HomeImgInfo> getYunYingTu();

    //信用资讯
    @GET("/users")
    Observable<List<User>> getUsers(@Query("since") int lastIdQueried, @Query("per_page") int perPage);

}
