/*
* 
*  Lowest common ancestor (LCA)
*  You are given references to two nodes in a binary tree.
*  Find the root of the smallest subtree that contains both nodes. (one node may be an ancestor of another, in *which case this node is the solution)
*  Please do it in O(h), where h is the height of the tree (and please use O(1) in space)
*
*                      a
*                     / \
*                    /   \
*                   b     c
*                  /\    / \
*                 z  w  e   d
*                           /\
*                          j  k
*
*  LCA(b, c) = a
*  LCA(d, k) = d
*  LCA(w, d) = a
*

class Node {
    constructor(value, parent) {
      this.value = value;
      this.parent = parent;
    }
    getParent() {
      return this.parent;
    }
  }
  
*/

import java.io.*;
import java.util.*;
// Node constractor(value, parent); getParent(value);

class Solution {
  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");
    strings.add("This pad is running Java " + Runtime.version().feature());

    Map<Character, String[]> myMap = new HashMap<>();
    for (String string : strings) {
      System.out.println(string);
    }

    

    lca();
  
  }


  private String lca(Node node1, Node node2) {
    List<String> node1Parents = getParents(node1);
    List<String> node2Parents = getParents(node2);
    List<String> adjustedParents = getParents(node2);

    if (node1Parents.size() < node2Parents.size()) {
      while (node1Parents.size() < node2Parents.size()) {
          node2Parents.remove(node2Parents.size());
        }
    }

    if (node1Parents.size() > node2Parents.size()) {
      while (node1Parents.size() > node2Parents.size()) {
          node1Parents.remove(node1Parents.size());
        }
    }
    for (String val: node1Parents) {
      if (val.equals(node2Parents.get(0))) {
        return val;
      }else{
        node2Parents.remove(0);
      }
    }
    return node2Parents.get(node2Parents.size()-1);
  }

  private List<String> getParents(Node node) {
    List<String> parents = new ArrayList<>(); 
    boolean hasParent = true;
      while (hasParent) {
        parents.add(node.value);
        if (node.parent == null) {
          return parents;
      }
      node = node.parent;
  }




}


class Node {
  public Node parent = null;
  public String value = null;
  public Node(String value,Node parent) {
    this.parent = parent;
  }
  
}
