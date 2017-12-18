package com.scimmia;

import java.util.List;

/**
 * Created by lk on 2017/12/18.
 */
public class BaiduInfo {
    /**
     * status : 0
     * size : 1
     * total : 1
     * pois : [{"title":"A18","location":[117.16381988936,36.677092442616],"city":"济南市","create_time":"2017-11-17 15:14:09","geotable_id":179625,"address":"","tags":"","province":"山东省","district":"历下区","fpm":"A118","gcj_location":[117.15728922222,36.671227154891],"city_id":288,"id":2381587769}]
     * message : 成功
     */

    private int status;
    private int size;
    private int total;
    private String message;
    private List<PoisBean> pois;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<PoisBean> getPois() {
        return pois;
    }

    public void setPois(List<PoisBean> pois) {
        this.pois = pois;
    }

    public static class PoisBean {
        /**
         * title : A18
         * location : [117.16381988936,36.677092442616]
         * city : 济南市
         * create_time : 2017-11-17 15:14:09
         * geotable_id : 179625
         * address :
         * tags :
         * province : 山东省
         * district : 历下区
         * fpm : A118
         * gcj_location : [117.15728922222,36.671227154891]
         * city_id : 288
         * id : 2381587769
         */

        private String title;
        private String create_time;
        private String tags;
        private String fpm;
        private long id;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public String getFpm() {
            return fpm;
        }

        public void setFpm(String fpm) {
            this.fpm = fpm;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "PoisBean{" +
                    "title='" + title + '\'' +
                    ", create_time='" + create_time + '\'' +
                    ", tags='" + tags + '\'' +
                    ", fpm='" + fpm + '\'' +
                    ", id=" + id +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "BaiduInfo{" +
                "status=" + status +
                ", size=" + size +
                ", total=" + total +
                ", message='" + message + '\'' +
                ", pois=" + pois +
                '}';
    }
}
