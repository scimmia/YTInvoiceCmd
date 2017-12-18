package com.scimmia;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    void beginF(){
        producerLatch = new CountDownLatch(10); //state值为10
        consumerLatch = new CountDownLatch(10); //state值为10

    }

    OkHttpClient client = new OkHttpClient();
    String getUrl(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    private static ArrayBlockingQueue<BaiduInfo.PoisBean> queue = new ArrayBlockingQueue<BaiduInfo.PoisBean>(5, true);
    private static CountDownLatch producerLatch; //倒计时计数器
    private static CountDownLatch consumerLatch;
    class DataFromBaiduTask implements Runnable{

        @Override
        public void run() {
            String url = "http://api.map.baidu.com/geodata/v3/poi/list?ak=Tlod6LwUv3iYIvLGUQr2jQdw&geotable_id=179625&page_size=15";
            String response = "";
            while(true){
                try {
                    response = getUrl(url);

                    BaiduInfo baiduInfo = new Gson().fromJson(response,BaiduInfo.class);
                    for (BaiduInfo.PoisBean p :
                            baiduInfo.getPois()) {
                        if (!DBUtil.isSaved(p.getId())){
                            queue.put(p);
                            producerLatch.await();
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
}
