package lruCache.src.main.impl;

import java.util.HashMap;
import java.util.Map;

class LruCache {

    private final Integer capacity;
    private Integer tailId;
    private Integer headId;
    private Map<Integer, CacheNode> dataMap;

    public LruCache(Integer capacity) {
        this.capacity = capacity;
        this.dataMap = new HashMap<>();
    }

    public String get(Integer id) {
        this.nodeMoveToTail(id);
        return this.dataMap.get(id).getData();
    }

    public void set(Integer id, String val) {
        updateOldTail(id);
        updateNewTail(id, val);
        while(dataMap.size() > capacity){
            trimHead();
        }
    }

    public void print() {
        String sb = getPrintableCacheOrder();
        System.out.println(sb);
    }

    private String getPrintableCacheOrder() {
        CacheNode currentNode = dataMap.get(headId);
        Integer nextIdToPrint = headId;
        StringBuilder sb = new StringBuilder();
        sb.append("HEAD-->");
        while(currentNode != null){
            sb.append(nextIdToPrint.toString() + "-->");
            nextIdToPrint = currentNode.getTo();
            currentNode = dataMap.get(currentNode.getTo());
        }
        sb.append("TAIL");
        return sb.toString();
    }

    private void updateOldTail(Integer newTailId) {
        if (tailId == null) {
            headId = newTailId;
            return;
        }
        CacheNode oldTail = dataMap.get(tailId);
        oldTail.setTo(newTailId);
        dataMap.put(tailId, oldTail);
    }

    private void updateNewTail(Integer id, String val) {
        CacheNode newTail = new CacheNode(val, tailId);
        dataMap.put(id, newTail);
        tailId = id;
    }

    private void trimHead() {
        CacheNode headNode = dataMap.get(headId);
        dataMap.remove(headId);
        headId = headNode.getTo();

        CacheNode newHeadNode = dataMap.get(headId);
        newHeadNode.setFrom(null);
        dataMap.put(headId, newHeadNode);
    }

    private void nodeMoveToTail(Integer id){
        CacheNode currentNode = this.dataMap.get(id);
        this.previousNodeUpdate(currentNode);
        this.nextNodeUpdate(currentNode, id);
        this.currentNodeUpdateAsTail(currentNode, id);
    }

    private void previousNodeUpdate(CacheNode currentNode){
        if (currentNode.getFrom() == null) {
            this.headId = currentNode.getTo();
        }else {
            this.updateExistingPreviousNode(currentNode);
        }
    }

    private void updateExistingPreviousNode(CacheNode currentNode){
        CacheNode fromNode = this.dataMap.get(currentNode.getFrom());
        fromNode.setTo(currentNode.getTo());
        this.dataMap.put(currentNode.getFrom(), fromNode);
    }

    private void nextNodeUpdate(CacheNode currentNode, Integer currentNodeId){
        CacheNode toNode = this.dataMap.get(currentNode.getTo());
        if (toNode == null) {
            return;
        }
        toNode.setFrom(currentNode.getFrom());
        if (toNode.getFrom() == null) {
            headId = currentNode.getTo();
        }
        if (toNode.getTo() == null) {
            toNode.setTo(currentNodeId);
        }
        this.dataMap.put(currentNode.getTo(), toNode);
    }

    private void currentNodeUpdateAsTail(CacheNode currentNode, Integer id){
        currentNode.setTo(null);
        currentNode.setFrom(this.tailId);
        this.dataMap.put(id, currentNode);
        this.tailId = id;
    }

}
