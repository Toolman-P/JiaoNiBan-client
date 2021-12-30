package com.jiaoniban.client.model.base;

import java.util.ArrayList;

public class BaseContentParser {
    public final static String[] parseContentString(String str){
        return str.split("\n");
    }
}
