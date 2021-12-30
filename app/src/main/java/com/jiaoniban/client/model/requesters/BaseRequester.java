package com.jiaoniban.client.model.requesters;

import android.os.AsyncTask;
import android.util.Log;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.*;

public class BaseRequester{

    private static OkHttpClient client=new OkHttpClient();



    public static String get(String url){

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {

                Request req = new Request.Builder().get().url(url).build();
                Response resp = null;
                try {
                    resp = client.newCall(req).execute();
                } catch (IOException e) {
                    throw e;
                }
                return resp.body().string();
            }
        };
        ExecutorService es = Executors.newSingleThreadExecutor();
        Future<String> future=es.submit(callable);
        String res=null;
        try {
            res=future.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(future.isDone()){
            return res;
        }
        return null;
    }
}
