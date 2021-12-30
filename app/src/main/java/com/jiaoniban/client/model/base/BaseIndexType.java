package com.jiaoniban.client.model.base;

public class BaseIndexType {
    private int latest;
    private int sum;

    public BaseIndexType(int latest, int sum) {
        this.latest = latest;
        this.sum = sum;
    }

    public int getLatest() {
        return latest;
    }

    public void setLatest(int latest) {
        this.latest = latest;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "BaseIndexType{" +
                "latest=" + latest +
                ", sum=" + sum +
                '}';
    }
}
