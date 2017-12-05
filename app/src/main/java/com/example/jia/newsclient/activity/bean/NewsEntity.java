package com.example.jia.newsclient.activity.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jia on 2017/6/27.
 */

public class NewsEntity {


    private List<ResultBean> result;

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean implements Serializable{
        /**
         * postid : PHOT25260000100A
         * hasCover : false
         * hasHead : 1
         * replyCount : 13089
         * hasImg : 1
         * digest :
         * hasIcon : false
         * docid : 9IG74V5H00963VRO_CO0LU9OJbjjikeupdateDoc
         * title : 西安持续高温 大学生在足球场过夜
         * order : 1
         * priority : 354
         * lmodify : 2017-06-28 08:35:53
         * boardid : photoview_bbs
         * ads : [{"title":"七一临近 香港维港两岸\"升起\"国旗区旗","skipID":"00AN0001|2263233","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/dfb19667874644d883213c47bdf9002820170628082619.jpeg","subtitle":"","skipType":"photoset","url":"00AN0001|2263233"},{"title":"美国纽约发生地铁脱轨事故 致34人受伤","skipID":"00AO0001|2263229","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/4947b7da071e46399cf953bd314eaf1f20170628081222.jpeg","subtitle":"","skipType":"photoset","url":"00AO0001|2263229"},{"title":"老太往飞机航发抛硬币祈福 致150人滞留","skipID":"00AP0001|2263174","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/7227e4922d5a4f01a37f9d30b613d3d920170627201248.jpeg","subtitle":"","skipType":"photoset","url":"00AP0001|2263174"},{"title":"母亲患白血病隐瞒1年多 儿子成高考状元","skipID":"00AP0001|2263143","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/49c1b986b5674fbcb93b129602e43ecc20170627155207.jpeg","subtitle":"","skipType":"photoset","url":"00AP0001|2263143"},{"title":"江苏淮安洪泽湖水位下降 船舶堵在河道","skipID":"00AN0001|2263175","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/72fc0b52cbbc4a4da94f98c1d2ec6c9820170627182715.jpeg","subtitle":"","skipType":"photoset","url":"00AN0001|2263175"}]
         * photosetID : 00AP0001|2263232
         * imgsum : 5
         * topic_background : http://img2.cache.netease.com/m/newsapp/reading/cover1/C1348646712614.jpg
         * template : normal1
         * votecount : 12004
         * skipID : 00AP0001|2263232
         * alias : Top News
         * skipType : photoset
         * cid : C1348646712614
         * hasAD : 1
         * imgextra : [{"imgsrc":"http://cms-bucket.nosdn.127.net/b1a973a4c81d4d349e8199e5feec973720170628082750.jpeg"},{"imgsrc":"http://cms-bucket.nosdn.127.net/7107e7d14ce54ae8b3b534f05b8d342320170628082751.jpeg"}]
         * source : 网易综合
         * ename : androidnews
         * tname : 头条
         * imgsrc : http://cms-bucket.nosdn.127.net/619478fbd57b48208e74981e950c37c220170628082751.jpeg
         * ptime : 2017-06-28 08:27:57
         * url_3w : http://news.163.com/17/0627/15/CNUQI2BR000189FH.html
         * ltitle : 习近平参观香港回归祖国20周年成就展
         * url : http://3g.163.com/news/17/0627/15/CNUQI2BR000189FH.html
         * subtitle :
         * specialID : S1497403767137
         * specialextra : [{"url_3w":"http://news.163.com/17/0627/14/CNUPBFDR00018AOQ.html","postid":"CNUPBFDR00018AOQ","votecount":160,"replyCount":232,"ltitle":"英中贸协主席：香港超出了20年前人们的期望","digest":"坐落在伦敦金融城的怡和集团办公楼，会议室里挂着一幅描绘19世纪广州码头风貌的油画，还有当时广州十三行的代表人物伍秉鉴的肖像画。在这个充满东方元素的会议室，怡和集","url":"http://3g.163.com/news/17/0627/14/CNUPBFDR00018AOQ.html","docid":"CNUPBFDR00018AOQ","title":"英中贸协主席：香港超出了20年前人们的期望","source":"中国新闻网","priority":80,"imgsrc":"http://cms-bucket.nosdn.127.net/1daafc5d9c6d4b669d56507dd224830620170627145545.png","subtitle":"S1498014591876#","boardid":"news2_bbs","ptime":"2017-06-27 14:41:00"},{"url_3w":"http://news.163.com/17/0628/04/CO06TH8400018AOP.html","postid":"CO06TH8400018AOP","votecount":9,"replyCount":126,"ltitle":"庆香港回归20周年 维港上空将燃4万枚烟花弹","digest":"随着7月1日临近，香港岛的多栋建筑物上新增了亮丽的灯饰。入夜，从尖沙咀望港岛，信和广场\u201c庆祝香港回归\u201d字样格外醒目。信和集团旗下的临海项目包括尖沙咀中心、中港城","url":"http://3g.163.com/news/17/0628/04/CO06TH8400018AOP.html","docid":"CO06TH8400018AOP","title":"庆香港回归20周年 维港上空将燃4万枚烟花弹","source":"人民网-人民日报","priority":78,"imgsrc":"http://cms-bucket.nosdn.127.net/e845b367a5ab40f4adcf37a6191e011a20170628091014.png","subtitle":"","boardid":"news2_bbs","ptime":"2017-06-28 04:04:47"}]
         * specialtip : 进入专题
         * speciallogo :
         * specialadlogo :
         */

        private String postid;
        private boolean hasCover;
        private int hasHead;
        private int replyCount;
        private int hasImg;
        private String digest;
        private boolean hasIcon;
        private String docid;
        private String title;
        private int order;
        private int priority;
        private String lmodify;
        private String boardid;
        private String photosetID;
        private int imgsum;
        private String topic_background;
        private String template;
        private int votecount;
        private String skipID;
        private String alias;
        private String skipType;
        private String cid;
        private int hasAD;
        private String source;
        private String ename;
        private String tname;
        private String imgsrc;
        private String ptime;
        private String url_3w;
        private String ltitle;
        private String url;
        private String subtitle;
        private String specialID;
        private String specialtip;
        private String speciallogo;
        private String specialadlogo;
        private List<AdsBean> ads;
        private List<ImgextraBean> imgextra;
        private List<SpecialextraBean> specialextra;

        public String getPostid() {
            return postid;
        }

        public void setPostid(String postid) {
            this.postid = postid;
        }

        public boolean isHasCover() {
            return hasCover;
        }

        public void setHasCover(boolean hasCover) {
            this.hasCover = hasCover;
        }

        public int getHasHead() {
            return hasHead;
        }

        public void setHasHead(int hasHead) {
            this.hasHead = hasHead;
        }

        public int getReplyCount() {
            return replyCount;
        }

        public void setReplyCount(int replyCount) {
            this.replyCount = replyCount;
        }

        public int getHasImg() {
            return hasImg;
        }

        public void setHasImg(int hasImg) {
            this.hasImg = hasImg;
        }

        public String getDigest() {
            return digest;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }

        public boolean isHasIcon() {
            return hasIcon;
        }

        public void setHasIcon(boolean hasIcon) {
            this.hasIcon = hasIcon;
        }

        public String getDocid() {
            return docid;
        }

        public void setDocid(String docid) {
            this.docid = docid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public String getLmodify() {
            return lmodify;
        }

        public void setLmodify(String lmodify) {
            this.lmodify = lmodify;
        }

        public String getBoardid() {
            return boardid;
        }

        public void setBoardid(String boardid) {
            this.boardid = boardid;
        }

        public String getPhotosetID() {
            return photosetID;
        }

        public void setPhotosetID(String photosetID) {
            this.photosetID = photosetID;
        }

        public int getImgsum() {
            return imgsum;
        }

        public void setImgsum(int imgsum) {
            this.imgsum = imgsum;
        }

        public String getTopic_background() {
            return topic_background;
        }

        public void setTopic_background(String topic_background) {
            this.topic_background = topic_background;
        }

        public String getTemplate() {
            return template;
        }

        public void setTemplate(String template) {
            this.template = template;
        }

        public int getVotecount() {
            return votecount;
        }

        public void setVotecount(int votecount) {
            this.votecount = votecount;
        }

        public String getSkipID() {
            return skipID;
        }

        public void setSkipID(String skipID) {
            this.skipID = skipID;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getSkipType() {
            return skipType;
        }

        public void setSkipType(String skipType) {
            this.skipType = skipType;
        }

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public int getHasAD() {
            return hasAD;
        }

        public void setHasAD(int hasAD) {
            this.hasAD = hasAD;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getEname() {
            return ename;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public String getTname() {
            return tname;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public String getUrl_3w() {
            return url_3w;
        }

        public void setUrl_3w(String url_3w) {
            this.url_3w = url_3w;
        }

        public String getLtitle() {
            return ltitle;
        }

        public void setLtitle(String ltitle) {
            this.ltitle = ltitle;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public String getSpecialID() {
            return specialID;
        }

        public void setSpecialID(String specialID) {
            this.specialID = specialID;
        }

        public String getSpecialtip() {
            return specialtip;
        }

        public void setSpecialtip(String specialtip) {
            this.specialtip = specialtip;
        }

        public String getSpeciallogo() {
            return speciallogo;
        }

        public void setSpeciallogo(String speciallogo) {
            this.speciallogo = speciallogo;
        }

        public String getSpecialadlogo() {
            return specialadlogo;
        }

        public void setSpecialadlogo(String specialadlogo) {
            this.specialadlogo = specialadlogo;
        }

        public List<AdsBean> getAds() {
            return ads;
        }

        public void setAds(List<AdsBean> ads) {
            this.ads = ads;
        }

        public List<ImgextraBean> getImgextra() {
            return imgextra;
        }

        public void setImgextra(List<ImgextraBean> imgextra) {
            this.imgextra = imgextra;
        }

        public List<SpecialextraBean> getSpecialextra() {
            return specialextra;
        }

        public void setSpecialextra(List<SpecialextraBean> specialextra) {
            this.specialextra = specialextra;
        }

        public static class AdsBean implements Serializable{
            /**
             * title : 七一临近 香港维港两岸"升起"国旗区旗
             * skipID : 00AN0001|2263233
             * tag : photoset
             * imgsrc : http://cms-bucket.nosdn.127.net/dfb19667874644d883213c47bdf9002820170628082619.jpeg
             * subtitle :
             * skipType : photoset
             * url : 00AN0001|2263233
             */

            private String title;
            private String skipID;
            private String tag;
            private String imgsrc;
            private String subtitle;
            private String skipType;
            private String url;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getSkipID() {
                return skipID;
            }

            public void setSkipID(String skipID) {
                this.skipID = skipID;
            }

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }

            public String getImgsrc() {
                return imgsrc;
            }

            public void setImgsrc(String imgsrc) {
                this.imgsrc = imgsrc;
            }

            public String getSubtitle() {
                return subtitle;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

            public String getSkipType() {
                return skipType;
            }

            public void setSkipType(String skipType) {
                this.skipType = skipType;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class ImgextraBean implements Serializable{
            /**
             * imgsrc : http://cms-bucket.nosdn.127.net/b1a973a4c81d4d349e8199e5feec973720170628082750.jpeg
             */

            private String imgsrc;

            public String getImgsrc() {
                return imgsrc;
            }

            public void setImgsrc(String imgsrc) {
                this.imgsrc = imgsrc;
            }
        }

        public static class SpecialextraBean implements Serializable{
            /**
             * url_3w : http://news.163.com/17/0627/14/CNUPBFDR00018AOQ.html
             * postid : CNUPBFDR00018AOQ
             * votecount : 160
             * replyCount : 232
             * ltitle : 英中贸协主席：香港超出了20年前人们的期望
             * digest : 坐落在伦敦金融城的怡和集团办公楼，会议室里挂着一幅描绘19世纪广州码头风貌的油画，还有当时广州十三行的代表人物伍秉鉴的肖像画。在这个充满东方元素的会议室，怡和集
             * url : http://3g.163.com/news/17/0627/14/CNUPBFDR00018AOQ.html
             * docid : CNUPBFDR00018AOQ
             * title : 英中贸协主席：香港超出了20年前人们的期望
             * source : 中国新闻网
             * priority : 80
             * imgsrc : http://cms-bucket.nosdn.127.net/1daafc5d9c6d4b669d56507dd224830620170627145545.png
             * subtitle : S1498014591876#
             * boardid : news2_bbs
             * ptime : 2017-06-27 14:41:00
             */

            private String url_3w;
            private String postid;
            private int votecount;
            private int replyCount;
            private String ltitle;
            private String digest;
            private String url;
            private String docid;
            private String title;
            private String source;
            private int priority;
            private String imgsrc;
            private String subtitle;
            private String boardid;
            private String ptime;

            public String getUrl_3w() {
                return url_3w;
            }

            public void setUrl_3w(String url_3w) {
                this.url_3w = url_3w;
            }

            public String getPostid() {
                return postid;
            }

            public void setPostid(String postid) {
                this.postid = postid;
            }

            public int getVotecount() {
                return votecount;
            }

            public void setVotecount(int votecount) {
                this.votecount = votecount;
            }

            public int getReplyCount() {
                return replyCount;
            }

            public void setReplyCount(int replyCount) {
                this.replyCount = replyCount;
            }

            public String getLtitle() {
                return ltitle;
            }

            public void setLtitle(String ltitle) {
                this.ltitle = ltitle;
            }

            public String getDigest() {
                return digest;
            }

            public void setDigest(String digest) {
                this.digest = digest;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getDocid() {
                return docid;
            }

            public void setDocid(String docid) {
                this.docid = docid;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public int getPriority() {
                return priority;
            }

            public void setPriority(int priority) {
                this.priority = priority;
            }

            public String getImgsrc() {
                return imgsrc;
            }

            public void setImgsrc(String imgsrc) {
                this.imgsrc = imgsrc;
            }

            public String getSubtitle() {
                return subtitle;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

            public String getBoardid() {
                return boardid;
            }

            public void setBoardid(String boardid) {
                this.boardid = boardid;
            }

            public String getPtime() {
                return ptime;
            }

            public void setPtime(String ptime) {
                this.ptime = ptime;
            }
        }
    }
}
