package com.example.mvpkuangjia2.mvp.ui.adapter;

import android.content.Context;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mvpkuangjia2.R;
import com.example.mvpkuangjia2.app.bean.HomeImgInfo;
import com.example.mvpkuangjia2.app.glid.GlideApp;
import com.example.mvpkuangjia2.mvp.model.api.Api;

import java.util.List;


/**
 * 文 件 名: AnimationAdapter
 * 创 建 人: Allen
 * 创建日期: 16/12/24 15:33
 * 邮   箱: AllenCoder@126.com
 * 修改时间：
 * 修改备注：
 */
public class XinYongDongTaiAdapter extends BaseQuickAdapter<HomeImgInfo.DataBean, BaseViewHolder> {
    Context context;
    public XinYongDongTaiAdapter(Context context,List<HomeImgInfo.DataBean> list) {
        super(R.layout.xin_yong_dong_tai_item, list);
        this.context = context;
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, HomeImgInfo.DataBean item) {
        ImageView imageView = helper.getView(R.id.imageView);
        GlideApp.with(context)
                .load(Api.APP_Img+item.getImg())
                .placeholder(R.mipmap.ic_launcher)
                .into(imageView);
        helper.setText(R.id.tv_title, item.getName()+"妇女节地方那个地方");
        helper.setText(R.id.tv_laiyuan, item.getName()+"妇女节地方那个地方");
        helper.setText(R.id.tv_time, item.getName()+"妇女节地方那个地方");

    }
}
