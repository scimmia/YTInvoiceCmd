package com.scimmia;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

/**
 * Created by lk on 2017/12/18.
 */
public class HttpUtil {
    static OkHttpClient client = new OkHttpClient();
    static String getUrl(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }
    static String baiduURL = "http://api.map.baidu.com/geodata/v3/poi/list?ak=Tlod6LwUv3iYIvLGUQr2jQdw&geotable_id=179625&page_size=15";

    static String getBaiduData(){
        String response = "";
        try {
            response = getUrl(baiduURL);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }


    static String getInvoiceCheck(String fpm) {
        String[] temp = StringUtils.split(fpm,",");
        if (temp.length == 4){
            return getInvoiceCheck(temp[0],temp[1],temp[2],temp[3]);
        }
        return null;
    }
    static String getInvoiceCheck(String fpdm,String fphm,String fprq,String fpje){

//        String fpdm = "037001600111";
//        String fphm = "02673663";
//        String fprq = "20170511";
//        String fpje = "316191";

        String tempRQ = fprq;
//        if (fprq.length() >= 8)
//            tempRQ = fprq.substring(0, 4) + '-' + fprq.substring(4, 6) + '-' + fprq.substring(6);
        String body = "{\"service\":\"newinvoice.service.invoiceService\",\"method\":\"getInvoiceInfo\",\"data\":{\"fpdm\":\"" + fpdm + "\"\n" +
                ",\"fphm\":\"" + fphm + "\",\"FPDM\":\"" + fpdm + "\",\"FPHM\":\"" + fphm + "\",\"key2\":\"\",\"key3\":\"\",\"kprq\":\"" + tempRQ + "\",\"fpje\"\n" +
                ":\"" + fpje + "\",\"yzm\":\"yzm\",\"yzmSj\":\"\",\"loginSj\":\"\",\"token\":\"\",\"username\":\"\",\"index\":\"\",\"new\":\"1\"}}";


        Request request = new Request.Builder()
                .url("https://www.leshui365.com/fapiao/ajax")
                .post(okhttp3.RequestBody.create(MediaType.parse("application/json; charset=utf-8"), body))
                .build();
        try {
            Response response = client.newCall(request).execute();
            if(response.isSuccessful()){
                String temp = response.body().string();
                return temp;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
