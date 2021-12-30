package com.jiaoniban.client.model.parsers;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jiaoniban.client.model.base.BaseContentType;
import com.jiaoniban.client.model.base.BaseDescType;
import com.jiaoniban.client.model.base.BaseIndexType;

import java.util.ArrayList;
import java.util.Iterator;

public class JSONParser {

    static public ArrayList<BaseDescType>parseDescList(String str){
        JSONObject baseJson= JSON.parseObject(str);
        JSONArray dataJsonArray = baseJson.getJSONArray("data");
        ArrayList<BaseDescType> arr = new ArrayList<>();
        for(Iterator it=dataJsonArray.iterator(); it.hasNext();){
            JSONObject dataJson=(JSONObject)it.next();
            String title=dataJson.getString("title");
            String author=dataJson.getString("author");
            String desc=dataJson.getString("description");
            int day=dataJson.getInteger("day");
            int month=dataJson.getInteger("month");
            int year=dataJson.getInteger("year");
            String id=dataJson.getString("sha256");
            String date=String.format("%d.%d.%d",year,month,day);
            arr.add(new BaseDescType(title,author,date,desc,id));
        }
        return arr;
    }

    static public BaseContentType parseContent(String str){
        JSONObject baseJson=JSON.parseObject(str);
        String body=baseJson.getString("body");
        String appendix=baseJson.getString("appendix");
        String id=baseJson.getString("sha256");
        return new BaseContentType(body,appendix,id);
    }

    static public BaseIndexType parseIndex(String str){
        JSONObject baseJson=JSON.parseObject(str);
        int latest=baseJson.getInteger("latest");
        int sum=baseJson.getInteger("sum");
        return new BaseIndexType(latest,sum);
    }
}
