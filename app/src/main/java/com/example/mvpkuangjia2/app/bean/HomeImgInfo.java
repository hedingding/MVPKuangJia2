package com.example.mvpkuangjia2.app.bean;

import java.util.List;

/**
 * Created by gyl on 2017/3/30.
 */

public class HomeImgInfo {

    /**
     * result : true
     * data : [{"id":"1","name":"1","img":"upload/adv/2018052903055638.jpg","sortnum":"0","is_open":"1","type_id":"1","addtime":"1471945678","url":""},{"id":"9","name":"4","img":"upload/adv/2019051009323298.jpg","sortnum":"0","is_open":"1","type_id":"1","addtime":"1557451952","url":""}]
     */

    private boolean result;
    private List<DataBean> data;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * name : 1
         * img : upload/adv/2018052903055638.jpg
         * sortnum : 0
         * is_open : 1
         * type_id : 1
         * addtime : 1471945678
         * url :
         */

        private String id;
        private String name;
        private String img;
        private String sortnum;
        private String is_open;
        private String type_id;
        private String addtime;
        private String url;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getSortnum() {
            return sortnum;
        }

        public void setSortnum(String sortnum) {
            this.sortnum = sortnum;
        }

        public String getIs_open() {
            return is_open;
        }

        public void setIs_open(String is_open) {
            this.is_open = is_open;
        }

        public String getType_id() {
            return type_id;
        }

        public void setType_id(String type_id) {
            this.type_id = type_id;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
