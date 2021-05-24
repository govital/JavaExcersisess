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

    public void get(Integer id) {

        if (this.dataMap.get(id) == null) {
            return;
        }
        if (id == headId && id == tailId) {
            return;
        }
        if (id == tailId) {
            return;
        }
        this.nodeMoveToTail(id);
    }

    public void set(Integer id, String val) {
        handleExistingIdSet(id);
        updateOldTail(id);
        updateNewTail(id, val);
        while(dataMap.size() > capacity){
            trimHead();
        }
    }

    private void handleExistingIdSet(Integer id) {
        CacheNode existingNode = dataMap.get(id);

        /**
         * setting when map is empty
         */
        if (dataMap.size() == 0) {
            return;
        }

        /**
         * setting when node not exist already in map
         */
        if (dataMap.get(id) == null) {
            return;
        }


        /**
         * setting when only single node and its same
         */
        if (id == headId && id == tailId) {
            return;
        }

        /**
         * setting when node exist and its tail
         */
        if (id == tailId) {
            return;
        }

        CacheNode toNode;
        CacheNode fromNode;

        /**
         * setting when id already exists and its the HEAD node.
         */
        if (id == headId) {
            toNode = dataMap.get(existingNode.getTo());
            toNode.setFrom(null);
            headId = existingNode.getTo();
            dataMap.put(existingNode.getTo(), toNode);
            return;
        }

        /**
         * setting when id already exists and its one of middle nodes.
         */
        if (id != tailId && dataMap.get(id) != null) {
            toNode = dataMap.get(existingNode.getTo());
            fromNode = dataMap.get(existingNode.getFrom());
            fromNode.setTo(existingNode.getTo());
            toNode.setFrom(existingNode.getFrom());
            return;
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
        sb.append("REAL     OUTPUT: HEAD-->");
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
        if (currentNode.getFrom() != null) {
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
        if (currentNodeId == headId) {
            toNode.setFrom(null);
            headId = currentNode.getTo();
        }else {
            toNode.setFrom(currentNode.getFrom());
        }
        this.dataMap.put(currentNode.getTo(), toNode);
    }

    private void currentNodeUpdateAsTail(CacheNode currentNode, Integer id){
        CacheNode oldTail = this.dataMap.get(tailId);
        oldTail.setTo(id);
        Integer oldTailId = tailId;
        currentNode.setTo(null);
        currentNode.setFrom(this.tailId);
        this.tailId = id;
        this.dataMap.put(id, currentNode);
        this.dataMap.put(oldTailId, oldTail);
    }

}
