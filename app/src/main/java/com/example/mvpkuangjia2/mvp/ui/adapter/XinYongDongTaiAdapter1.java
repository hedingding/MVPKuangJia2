package com.example.mvpkuangjia2.mvp.ui.adapter;

import android.content.Context;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mvpkuangjia2.R;
import com.example.mvpkuangjia2.app.bean.User;
import com.example.mvpkuangjia2.app.glid.GlideApp;
import com.example.mvpkuangjia2.app.utils.Utils;

import java.util.List;


/**
 * 文 件 名: AnimationAdapter
 * 创 建 人: Allen
 * 创建日期: 16/12/24 15:33
 * 邮   箱: AllenCoder@126.com
 * 修改时间：
 * 修改备注：
 */
public class XinYongDongTaiAdapter1 extends BaseQuickAdapter<User, BaseViewHolder> {
    Context context;
    public XinYongDongTaiAdapter1(Context context) {
        super(R.layout.xin_yong_dong_tai_item);
        this.context = context;
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, User item) {
        ImageView imageView=helper.getView(R.id.imageView);
        GlideApp.with(context)
                    .load(item.getAvatar_url())
                .placeholder(R.mipmap.ic_launcher)
                .into(imageView);
        helper.setText(R.id.tv_title, item.getAvatar_url());
        helper.setText(R.id.tv_laiyuan, item.getLogin());
        helper.setText(R.id.tv_time, item.getLogin());

    }
}
