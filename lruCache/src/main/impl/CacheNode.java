package lruCache.src.main.impl;

public class CacheNode {
    private String data;
    private Integer from;
    private Integer to;

    public CacheNode(String data, Integer oldTailId) {
        this.data = data;
        this.from = oldTailId;

    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }
}
