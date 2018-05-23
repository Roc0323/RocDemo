package cn.roc.rocdemo.bean;

/**
 * Created by Roc on 2018/5/23.
 */

public class TestConfigBean {


    /**
     * data : {"qiniu_img_pre":"http://ocuw2gabq.bkt.clouddn.com/","android":{"apk_url":"http://shop.gongchangtemai.com/data/upload/app/ypcang-new.apk","version":"2.0.3","level":0,"desc":"1、支持商品图文信息一键转发到朋友圈~\n2、新增线下活动现场动态，一起来感受火爆的活动现场吧!\n3、当天重复购买，合并包裹免运费，让您购买更舒心~"},"ios":{"app_url":"https://itunes.apple.com/us/app/yi-pin-cang-yi-ge-zhuan-men/id1187823503?l=zh&ls=1&mt=8","version":"260","level":1,"desc":"1、支持商品图文信息一键转发到朋友圈~\n2、新增线下活动现场动态，一起来感受火爆的活动现场吧!\n3、当天重复购买，合并包裹免运费，让您购买更舒心~","is_checking":2},"app_name":"扫货神器","share_data":{"share_goods":{"title":"【壹品仓】工厂特卖 限时抢购","content":"%@工厂仓库特卖中，%@折  %@元","url":"http://shop.gongchangtemai.com/weixin/index.php?m=app&c=index&a=appjump&goods_straceid=%@&uid=%@"},"share_app":{"title":"壹品仓 一个做品牌工厂特卖的仓库","content":"让我们的买手在特卖会现场、工厂仓库、生产车间为大家直播商品和代购，让您足不出户，淘工厂！品牌正品，工厂特卖，快到APP挑选吧！","url":"http://shop.gongchangtemai.com/weixin/index.php?m=app&c=index&a=appjump&uid=%@"}},"api_url":"https://api.gongchangtemai.com/1.7/index.php","latest_version":"260","has_activity":"0","goods_url":"http://shop.gongchangtemai.com/g/"}
     * status : {"succeed":1}
     */

    private DataBean data;
    private StatusBean status;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }

    public static class DataBean {
        /**
         * qiniu_img_pre : http://ocuw2gabq.bkt.clouddn.com/
         * android : {"apk_url":"http://shop.gongchangtemai.com/data/upload/app/ypcang-new.apk","version":"2.0.3","level":0,"desc":"1、支持商品图文信息一键转发到朋友圈~\n2、新增线下活动现场动态，一起来感受火爆的活动现场吧!\n3、当天重复购买，合并包裹免运费，让您购买更舒心~"}
         * ios : {"app_url":"https://itunes.apple.com/us/app/yi-pin-cang-yi-ge-zhuan-men/id1187823503?l=zh&ls=1&mt=8","version":"260","level":1,"desc":"1、支持商品图文信息一键转发到朋友圈~\n2、新增线下活动现场动态，一起来感受火爆的活动现场吧!\n3、当天重复购买，合并包裹免运费，让您购买更舒心~","is_checking":2}
         * app_name : 扫货神器
         * share_data : {"share_goods":{"title":"【壹品仓】工厂特卖 限时抢购","content":"%@工厂仓库特卖中，%@折  %@元","url":"http://shop.gongchangtemai.com/weixin/index.php?m=app&c=index&a=appjump&goods_straceid=%@&uid=%@"},"share_app":{"title":"壹品仓 一个做品牌工厂特卖的仓库","content":"让我们的买手在特卖会现场、工厂仓库、生产车间为大家直播商品和代购，让您足不出户，淘工厂！品牌正品，工厂特卖，快到APP挑选吧！","url":"http://shop.gongchangtemai.com/weixin/index.php?m=app&c=index&a=appjump&uid=%@"}}
         * api_url : https://api.gongchangtemai.com/1.7/index.php
         * latest_version : 260
         * has_activity : 0
         * goods_url : http://shop.gongchangtemai.com/g/
         */

        private String qiniu_img_pre;
        private AndroidBean android;
        private IosBean ios;
        private String app_name;
        private ShareDataBean share_data;
        private String api_url;
        private String latest_version;
        private String has_activity;
        private String goods_url;

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

        public String getApp_name() {
            return app_name;
        }

        public void setApp_name(String app_name) {
            this.app_name = app_name;
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

        public String getHas_activity() {
            return has_activity;
        }

        public void setHas_activity(String has_activity) {
            this.has_activity = has_activity;
        }

        public String getGoods_url() {
            return goods_url;
        }

        public void setGoods_url(String goods_url) {
            this.goods_url = goods_url;
        }

        public static class AndroidBean {
            /**
             * apk_url : http://shop.gongchangtemai.com/data/upload/app/ypcang-new.apk
             * version : 2.0.3
             * level : 0
             * desc : 1、支持商品图文信息一键转发到朋友圈~
             2、新增线下活动现场动态，一起来感受火爆的活动现场吧!
             3、当天重复购买，合并包裹免运费，让您购买更舒心~
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
             * app_url : https://itunes.apple.com/us/app/yi-pin-cang-yi-ge-zhuan-men/id1187823503?l=zh&ls=1&mt=8
             * version : 260
             * level : 1
             * desc : 1、支持商品图文信息一键转发到朋友圈~
             2、新增线下活动现场动态，一起来感受火爆的活动现场吧!
             3、当天重复购买，合并包裹免运费，让您购买更舒心~
             * is_checking : 2
             */

            private String app_url;
            private String version;
            private int level;
            private String desc;
            private int is_checking;

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

            public int getIs_checking() {
                return is_checking;
            }

            public void setIs_checking(int is_checking) {
                this.is_checking = is_checking;
            }
        }

        public static class ShareDataBean {
            /**
             * share_goods : {"title":"【壹品仓】工厂特卖 限时抢购","content":"%@工厂仓库特卖中，%@折  %@元","url":"http://shop.gongchangtemai.com/weixin/index.php?m=app&c=index&a=appjump&goods_straceid=%@&uid=%@"}
             * share_app : {"title":"壹品仓 一个做品牌工厂特卖的仓库","content":"让我们的买手在特卖会现场、工厂仓库、生产车间为大家直播商品和代购，让您足不出户，淘工厂！品牌正品，工厂特卖，快到APP挑选吧！","url":"http://shop.gongchangtemai.com/weixin/index.php?m=app&c=index&a=appjump&uid=%@"}
             */

            private ShareGoodsBean share_goods;
            private ShareAppBean share_app;

            public ShareGoodsBean getShare_goods() {
                return share_goods;
            }

            public void setShare_goods(ShareGoodsBean share_goods) {
                this.share_goods = share_goods;
            }

            public ShareAppBean getShare_app() {
                return share_app;
            }

            public void setShare_app(ShareAppBean share_app) {
                this.share_app = share_app;
            }

            public static class ShareGoodsBean {
                /**
                 * title : 【壹品仓】工厂特卖 限时抢购
                 * content : %@工厂仓库特卖中，%@折  %@元
                 * url : http://shop.gongchangtemai.com/weixin/index.php?m=app&c=index&a=appjump&goods_straceid=%@&uid=%@
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

            public static class ShareAppBean {
                /**
                 * title : 壹品仓 一个做品牌工厂特卖的仓库
                 * content : 让我们的买手在特卖会现场、工厂仓库、生产车间为大家直播商品和代购，让您足不出户，淘工厂！品牌正品，工厂特卖，快到APP挑选吧！
                 * url : http://shop.gongchangtemai.com/weixin/index.php?m=app&c=index&a=appjump&uid=%@
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

    public static class StatusBean {
        /**
         * succeed : 1
         */

        private int succeed;

        public int getSucceed() {
            return succeed;
        }

        public void setSucceed(int succeed) {
            this.succeed = succeed;
        }
    }

    @Override
    public String toString() {
        return "TestConfigBean{" +
                "data=" + data +
                ", status=" + status +
                '}';
    }
}
