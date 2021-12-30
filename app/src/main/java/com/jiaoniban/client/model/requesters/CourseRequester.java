package com.jiaoniban.client.model.requesters;

import android.util.Log;

public class CourseRequester {
    public final static String getIndexJSON(String server,String opt){
        String url=String.format("%s/api/index?author=%s",server,opt);
        Log.d("url", url);
        return BaseRequester.get(url);
    }

    public final static String getLatestListJSON(String server){
        String url=String.format("%s/api/latest", server);
        Log.d("url", url);
        return BaseRequester.get(url);
    }

    public final static String getDescListJSON(String server,String opt,int page){
        String url=String.format("%s/api/website/desc?author=%s&page=%d",server,opt,page);
        return BaseRequester.get(url);
    }

    public final static String getContentJSON(String server,String opt,String id){
        String url=String.format("%s/api/website/content?author=%s&id=%s",server,opt,id);
        return BaseRequester.get(url);
    }

}
