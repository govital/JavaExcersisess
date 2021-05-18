package lruCache.src.main.impl;

import java.util.HashMap;
import java.util.Map;

class LruCache {

    private Integer qLimit;
    private boolean limitReached;
    private Integer tailId;
    private Integer headId;
    private Map<Integer, CacheNode> dataMap;

    public LruCache(Integer qLimit) {
        this.qLimit = qLimit;
        this.limitReached = false;
        this.dataMap = new HashMap<>();
    }

    public String get(Integer id) {
        //manage queue
        // * take id out of its place in line.
        // * insert id to tail
        // * if queue limit reached: remove queue head ( from map also )
        //
        this.nodeMoveToTail(id);
        return this.dataMap.get(id).getData();

    }


    public void set(Integer id, String val) {

        CacheNode newTail = new CacheNode(val, this.tailId);




    }

    private void nodeMoveToTail(Integer id){
        CacheNode theNode = this.dataMap.get(id);

        if (theNode.getFrom() == null) {
            this.headId = theNode.getTo();
        }else {
            CacheNode fromNode = this.dataMap.get(theNode.getFrom());
            fromNode.setTo(theNode.getTo());
        }

        CacheNode toNode = this.dataMap.get(theNode.getTo());
        toNode.setFrom(theNode.getFrom());

        theNode.setTo(null);
        theNode.setFrom(this.tailId);

        this.tailId = id;

    }

}
