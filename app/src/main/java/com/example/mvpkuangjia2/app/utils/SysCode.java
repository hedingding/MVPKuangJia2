package com.example.mvpkuangjia2.app.utils;



public class SysCode {
    public static final String LOGIN_TOKEN = "token";
    /**
     * 发送退出登录通知
     */
    public static final String BASICBUS_EXIT_LOGIN = "exit_login";
    public static final int TOAST_TIME = 2000;

    public static final String UCCP_HOST = "com.iflytek.hfcredit";

    /**
     * 网络请求编码
     */
    public interface REQUEST_CODE {
        //图片轮播
        String PIC_LOOP = "c5f04087bbea473ea266aadf1fd2db80";
        //信用查询
        String XINYONGCHAXUN = "2a3c0f0ae59f4c79a69d048f24c6765b";
        //信用图片
        String XINYONGTUPIAN = "cb287984aa4c484caf02246f1171e541";
        //信用动态
        String XINYONGDONGTAI = "6b00b6541bd14f4f9f5879019fe1c6a3";
        //信用资讯的标题
        String XINYONGZIXUNBIAOTI = "011f409fe3354f788d7417f5540199a2";
        //信用资讯的信用动态
        String XINYONGDONGTAI1 = "27f376e93a5c42328d4a7f1e716d1710";
        //信用公示
        String XINYONGGONGSHI= "011f409fe3354f788d7417f5540199a2";
        //我的接口
        String WODE= "b5a4ff2158384217be410540472195f2";
        //双公示行政许可
        String SGSXZXK="c196c11b614246a780ecb18b432fa676";
        //双公示行政处罚
        String SGSXZCF= "18bba9ffe3254bf39b0ea4346d9313c9";
        //红黑名单红名单
        String HHMDHONGMD = "b4299701c4664643a0bce88f3d34cf4e";
        //红黑名单黑名单
        String HHMDHEIMD = "82dc9a6c25ae42c2b5d8993f47a882bf";
        //首页信用查询
        String SHOUYEXYCX = "9d44ce39632c4a8daedc4039ed2ee13c";
        //信用承诺
        String XINYONGCHENGNUO = "12131f9351e44b2fb4c1f4a3ff3fb26e";
        //重点人群
        String ZDRQ = "492806c0d82942b98b5f5ad40823a276";
        //版本更新
        String BanBenGenXin = "7137324e3b14436883c058831ab51d70";
        //退出登录
        String TUICHUDENGLU = "d56e5952948f4d2fbc87d94e5964ac58";
        //预约时间列表
        String YUYUELIEBIAO = "e23f51bb21344133b0d5570fd04019d8";
        //交流互动
        String JIAOLIUHUDONG = "71ff3e13421347a4b894228e3a7bca20";
        //交流互动我要咨询附件
        String WOYAOZIXUNFUJIAN = "3aefdba27a9041ad8c314f1cf3cb6604";
        //异议申请附件
        String YIYISHENGQINGFUJIAN = "57dbe1779395485e9cbb364ec6946db6";
        //交流互动我要咨询提交
        String WOYAOZIXUNTIJIAO= "fd9f4adecd1e4c27bca8b2485ed2de2f";
        //预约查询记录
        String YuYueChaXunJiLu = "2b7fc4f331dc4a468554940df66ce377";
        //个人提交预约信息
        String GERENYUYUE = "68eec7d5301c4b2485587683fb9b7df0";
        //企业提交预约信息
        String QIYEYUYUE = "6bd1f3df6b424e89b265fb9a5a51f3e9";
        //预约查询记录详情
        String YuYueChaXunJiLuXIANGQING = "46dd95e232224d138607b725edcbbd5b";
        //取消预约
        String QUXIAOYUYUE = "4817d050b94a44d88e4477cd76ef3c99";
        //预约改期
        String YUYUEGAIQI = "f733b127cc9342b88d932e79778120bd";
        //我的消息
        String XIAOXI = "4606c3e6e2db428186aaa87a20e65ea4";
        //我的消息更新点
        String XIAOXIGXDIAN = "115d933efd7b4cf9bcfb7f304ac7330d";
        //极光ID更新
        String JIGUANGIDGEMXIN = "cbd8ac3efb0843878581b3c90fc08e0c";
        //我的消息数量
        String XIAOXISHULIANG = "18fabc265f8c447082572c690f4490d8";
        //异议申请记录列表
        String YIYISHENGQINGJILU = "0fe469e1784c449fadb1822f44148689";
        //异议申请记录点
        String YIYISHENGQINGJILUDIAN = "d7c57369bfe84f4ea88fc655363b83c7";
        //异议申请记录详情 已提交
        String YIYISHENGQINGJILUTIJIAO = "89fc7d87964b440282ee99cfeb73b67c";
        //异议申请--异议单据撤回
        String YIYICHEHUI = "7b2b17d5aeee4c5a88422f2410e2126b";
        //异议申请--驳回原因
        String YIYISHENGQINGBHYY = "9670a604bbb24719aacd80a8ef0f6224";
        //异议申请--处理结果
        String YIYISHENGQINGCLJG= "3af37f7d307848c3bad7aaa3b191567e";
        //异议申请-新增异议内容-获取主表id
        String YIYISHENGQINGXINGZENGID = "79fe957050b840d39a5e01b0dae9492f";
        //异议申请-新增异议内容-保存
        String YIYISHENGQINGXINGZENG = "32168048b6584d7aab63d3371ae473a3";
        //异议申请-新增异议内容-信源部门
        String YIYISHENGQINGXINGZENGXYBM = "d4d2f68d1a8e407c80c1d589080f981b";
        //异议申请-列表
        String YIYISHENGQINGLIEBIAO= "fc43f92d64eb4d78ab648308b9d95fbf";
        //异议申请-列表新增
        String YIYISHENGQINGLIEBIAO1= "d0f98a7d8c9e4cae8150bf213cdedb91";
        //异议申请-列表删除
        String YIYISHENGQINGLIEBIAOSC= "e85e071265f942418c0f54bd12552b8a";
        //异议申请-列表提交
        String YIYISHENGQINGLIEBIAOTJ= "e3c5aeb830b7469f8e6c106d40548fc0";
        //异议纠错-提交
        String YIYIJIUCUOTIJIAO = "22800a70d82242c89a780452b9e74e63";
        //异议纠错-列表
        String YIYIJIUCUOTIJIAOLB = "f9b604e1f9c848fa87131b5b2e6f9cc1";
        //异议纠错-撤回
        String YIYIJIUCUOTIJIAOCH = "57140b2607804efebbe898d1428983ba";
        //异议纠错-详情
        String YIYIJIUCUOTIJIAOXQ = "b341b283b1ba46fc8e788472c78b99db";
        //登录
        String LOGIN = "cd9cf6fedb00408b9532f23edf412e5a";
    }

    /**
     * 错误码
     */
    public interface ERROR_CODE {
        String UNKNOWEN_ERROR  = "100000";
        String CONNECT_ERROR   = "100001";
        String SOCKET_ERROR    = "100002";
        String TIMEOUT_ERROR   = "100003";
        String NET_NOT_CONNECT = "100004";
    }

    /**
     * 错误码名称
     */
    public interface ERROR_NAME {
        String UNKNOWEN_ERROR  = "未知的错误，请联系管理员！";
        String CONNECT_ERROR   = "服务端连接错误！";
        String SOCKET_ERROR    = "服务器地址无法访问！";
        String TIMEOUT_ERROR   = "服务器连接超时，请检查网络！";
        String NET_NOT_CONNECT = "网络未连接，请先连接网络！";
    }

    /**
     * SharedPreferences配置文件中的 配置项
     */
    public interface SHAREDPREFERENCES {
        // 后台数据库用户id
        String USER_ID = "userId";
        // 实名认证状态
        String USER_CERTIFY = "user_certify";
        // 登录名
        String LOGIN_NAME = "loginName";
        // 手机号
        String USER_PHONE = "userPhone";
        // 用户登录时输入的登录名（可能是手机号、登录名、身份证）
        String USERNAME = "login_name_value";
        // 用户登录时输入的密码
        String PASSWORD = "password_value";
        // 用户推送的 did
        String DID = "did";
        //是否需要刷新用户数据
        String IS_REFRESH_USER = "isRefreshUser";
        String AREA_ENCODE = "area_encode";
        //是否需要刷新
        String IS_REFRESH = "isRefresh";
    }


}
