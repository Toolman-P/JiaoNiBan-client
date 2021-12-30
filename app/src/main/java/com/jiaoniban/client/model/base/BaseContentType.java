package com.jiaoniban.client.model.base;

public class BaseContentType {
    private String body;
    private String adix;
    private String id;

    public BaseContentType(String body, String adix, String id) {
        this.body = body;
        this.adix = adix;
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAdix() {
        return adix;
    }

    public void setAdix(String adix) {
        this.adix = adix;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BaseContentType{" +
                "body='" + body + '\'' +
                ", adix='" + adix + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
