package com.scimmia;

import com.google.gson.Gson;
import com.scimmia.db.InvoiceBean;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.TimeUnit;

/**
 * Created by lk on 2017/12/18.
 */
public class Go {
    public static void main(String[] args) {
//        String response = "";
//        while (true){
//            response = HttpUtil.getBaiduData();
//
//        }
        Thread t1 = new Thread(new DataFromBaiduTask());
        t1.start();
//        new DataFromBaiduTask().run();
    }
    static class DataFromBaiduTask implements Runnable{

        @Override
        public void run() {
            String response = "";
            while(true){
                try {
                    response = HttpUtil.getBaiduData();

                    BaiduInfo baiduInfo = new Gson().fromJson(response,BaiduInfo.class);
                    for (BaiduInfo.PoisBean p :
                            baiduInfo.getPois()) {
                        if (!DBUtil.isSaved(p.getId())){
                            DBUtil.insertInvoice(p);
                            String i = HttpUtil.getInvoiceCheck(p.getFpm());
                            CheckResult c = new Gson().fromJson(i,CheckResult.class);
                            System.out.println("-------------------------------");
                            System.out.println(c.toShow());
                            System.out.println("-------------------------------");



                        }
                    }
                    TimeUnit.SECONDS.sleep(2); //线程休眠2秒
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                }  catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        }
    }

    static InvoiceBean baiduToInvoice(BaiduInfo.PoisBean poisBean){
        InvoiceBean i = null;
        if (poisBean != null){

            String[] t = StringUtils.split(poisBean.getFpm(),",");
            if (t.length == 4){
                i = new InvoiceBean(t[0],t[1],t[2],t[3]);
                i.setId(poisBean.getId());
            }else {
                String[] temps = StringUtils.splitPreserveAllTokens(poisBean.getTitle(),",");
                String fpdm = null;
                String fphm = null;
                String fprq = null;
                String fpje = null;
                for (String temp :
                        temps) {
                    if (StringUtils.isEmpty(fpdm)) {
                        if (temp.length() == 12 || temp.length() == 10){
                            fpdm = (temp);
                        }
                    }else if (StringUtils.isEmpty(fphm)) {
                        if (temp.length() == 8){
                            fphm = temp.substring(0, 4) + '-' + temp.substring(4, 6) + '-' + temp.substring(6);
                        }
                    }else if (StringUtils.isEmpty(fprq)) {
                        if (temp.length() == 8){
                            fprq = (temp);
                        }
                    }else if (StringUtils.isEmpty(fpje)) {
                        if (temp.length() > 14){
                            fpje = (StringUtils.substring(temp,temp.length()-6));
                        }
                    }
                }
                i = new InvoiceBean(fpdm,fphm,fprq,fpje);
                i.setId(poisBean.getId());
            }
        }
        return i;
    }
}
