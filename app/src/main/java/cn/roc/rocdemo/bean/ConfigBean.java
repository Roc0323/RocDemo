package cn.roc.rocdemo.bean;

/**
 * Created by Roc on 2017/5/17 0017.
 */

public class ConfigBean{

    /**
     * qiniu_img_pre : http://ocuw2gabq.bkt.clouddn.com/
     * android : {"apk_url":"","version":"","level":0,"desc":""}
     * ios : {"app_url":"","version":"23","level":0,"desc":""}
     * share_data : {"share_store":{"title":"%@ 带您去工厂淘大牌进行中...","content":"袋袋购邀请您关注红人%@，带您一起去工厂淘大牌。","url":"http://tshop.gongchangtemai.com/weixin/index.php?m=app&c=index&a=appjump&seller_id=%@&uid=%@"},"share_goods":{"title":"【袋袋购】工厂特卖 限时抢购","content":"%@工厂仓库特卖中，%@折  %@元","url":"http://tshop.gongchangtemai.com/weixin/index.php?m=app&c=index&a=appjump&goods_straceid=%@&uid=%@"}}
     * api_url : http://ddbuyapi.gongchangtemai.com/index.php?url=
     * latest_version : 23
     */

    private String qiniu_img_pre;
    private AndroidBean android;
    private IosBean ios;
    private ShareDataBean share_data;
    private String api_url;
    private String latest_version;

    public String getQiniu_img_pre() {
        return qiniu_img_pre;
    }

    public void setQiniu_img_pre(String qiniu_img_pre) {
        this.qiniu_img_pre = qiniu_img_pre;
    }

    public AndroidBean getAndroid() {
        return android;
    }

    public void setAndroid(AndroidBean android) {
        this.android = android;
    }

    public IosBean getIos() {
        return ios;
    }

    public void setIos(IosBean ios) {
        this.ios = ios;
    }

    public ShareDataBean getShare_data() {
        return share_data;
    }

    public void setShare_data(ShareDataBean share_data) {
        this.share_data = share_data;
    }

    public String getApi_url() {
        return api_url;
    }

    public void setApi_url(String api_url) {
        this.api_url = api_url;
    }

    public String getLatest_version() {
        return latest_version;
    }

    public void setLatest_version(String latest_version) {
        this.latest_version = latest_version;
    }

    public static class AndroidBean {
        /**
         * apk_url :
         * version :
         * level : 0
         * desc :
         */

        private String apk_url;
        private String version;
        private int level;
        private String desc;

        public String getApk_url() {
            return apk_url;
        }

        public void setApk_url(String apk_url) {
            this.apk_url = apk_url;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

    public static class IosBean {
        /**
         * app_url :
         * version : 23
         * level : 0
         * desc :
         */

        private String app_url;
        private String version;
        private int level;
        private String desc;

        public String getApp_url() {
            return app_url;
        }

        public void setApp_url(String app_url) {
            this.app_url = app_url;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

    public static class ShareDataBean {
        /**
         * share_store : {"title":"%@ 带您去工厂淘大牌进行中...","content":"袋袋购邀请您关注红人%@，带您一起去工厂淘大牌。","url":"http://tshop.gongchangtemai.com/weixin/index.php?m=app&c=index&a=appjump&seller_id=%@&uid=%@"}
         * share_goods : {"title":"【袋袋购】工厂特卖 限时抢购","content":"%@工厂仓库特卖中，%@折  %@元","url":"http://tshop.gongchangtemai.com/weixin/index.php?m=app&c=index&a=appjump&goods_straceid=%@&uid=%@"}
         */

        private ShareStoreBean share_store;
        private ShareGoodsBean share_goods;

        public ShareStoreBean getShare_store() {
            return share_store;
        }

        public void setShare_store(ShareStoreBean share_store) {
            this.share_store = share_store;
        }

        public ShareGoodsBean getShare_goods() {
            return share_goods;
        }

        public void setShare_goods(ShareGoodsBean share_goods) {
            this.share_goods = share_goods;
        }

        public static class ShareStoreBean {
            /**
             * title : %@ 带您去工厂淘大牌进行中...
             * content : 袋袋购邀请您关注红人%@，带您一起去工厂淘大牌。
             * url : http://tshop.gongchangtemai.com/weixin/index.php?m=app&c=index&a=appjump&seller_id=%@&uid=%@
             */

            private String title;
            private String content;
            private String url;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class ShareGoodsBean {
            /**
             * title : 【袋袋购】工厂特卖 限时抢购
             * content : %@工厂仓库特卖中，%@折  %@元
             * url : http://tshop.gongchangtemai.com/weixin/index.php?m=app&c=index&a=appjump&goods_straceid=%@&uid=%@
             */

            private String title;
            private String content;
            private String url;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
