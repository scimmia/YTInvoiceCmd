package com.scimmia.db;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lk on 2017/12/18.
 */
public class InvoiceBean {
    long id;
    String fpdm;
    String fphm;
    String fprq;
    String fpje;

    String piaozhong;
    String xiaoshoufang;
    String goumaifang;
    String jine;
    String shuie;
    String jiashuiheji;
    String zuofei;
    String createtime;
    String beizhua;
    String beizhub;

    public InvoiceBean(String fpdm, String fphm, String fprq, String fpje) {
        this.fpdm = fpdm;
        this.fphm = fphm;
        this.fprq = fprq;
        this.fpje = fpje;
        this.createtime = new SimpleDateFormat("yy-MM-dd HH:mm").format(new Date());
    }

    @Override
    public String toString() {
        return "BaiduInfo{" +
                "fpdm='" + fpdm + '\'' +
                ", fphm='" + fphm + '\'' +
                ", fprq='" + fprq + '\'' +
                ", fpje='" + fpje + '\'' +
                ", piaozhong='" + piaozhong + '\'' +
                ", xiaoshoufang='" + xiaoshoufang + '\'' +
                ", goumaifang='" + goumaifang + '\'' +
                ", jine='" + jine + '\'' +
                ", shuie='" + shuie + '\'' +
                ", jiashuiheji='" + jiashuiheji + '\'' +
                ", zuofei='" + zuofei + '\'' +
                ", createtime='" + createtime + '\'' +
                '}';
    }
    public String toshow() {
        String msgToShow =
                createtime+ "\n"+

                        piaozhong + "\n" +
                        xiaoshoufang + "\n" +
                        goumaifang + "\n" +
                        jine + "  +   " + shuie + "  =  " + jiashuiheji + "\n" +
                        "是否作废=" + zuofei

                ;

        return msgToShow;
    }
    public String getFpdm() {
        return fpdm;
    }

    public void setFpdm(String fpdm) {
        this.fpdm = fpdm;
    }

    public String getFphm() {
        return fphm;
    }

    public void setFphm(String fphm) {
        this.fphm = fphm;
    }

    public String getFprq() {
        return fprq;
    }

    public void setFprq(String fprq) {
        this.fprq = fprq;
    }

    public String getFpje() {
        return fpje;
    }

    public void setFpje(String fpje) {
        this.fpje = fpje;
    }

    public String getPiaozhong() {
        return piaozhong;
    }

    public void setPiaozhong(String piaozhong) {
        this.piaozhong = piaozhong;
    }

    public String getXiaoshoufang() {
        return xiaoshoufang;
    }

    public void setXiaoshoufang(String xiaoshoufang) {
        this.xiaoshoufang = xiaoshoufang;
    }

    public String getGoumaifang() {
        return goumaifang;
    }

    public void setGoumaifang(String goumaifang) {
        this.goumaifang = goumaifang;
    }

    public String getJine() {
        return jine;
    }

    public void setJine(String jine) {
        this.jine = jine;
    }

    public String getShuie() {
        return shuie;
    }

    public void setShuie(String shuie) {
        this.shuie = shuie;
    }

    public String getJiashuiheji() {
        return jiashuiheji;
    }

    public void setJiashuiheji(String jiashuiheji) {
        this.jiashuiheji = jiashuiheji;
    }

    public String getZuofei() {
        return zuofei;
    }

    public void setZuofei(String zuofei) {
        this.zuofei = zuofei;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBeizhua() {
        return beizhua;
    }

    public void setBeizhua(String beizhua) {
        this.beizhua = beizhua;
    }

    public String getBeizhub() {
        return beizhub;
    }

    public void setBeizhub(String beizhub) {
        this.beizhub = beizhub;
    }
}
