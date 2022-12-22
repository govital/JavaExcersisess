package org.example.SubtreeOfAnotherTree;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class SubtreeOfAnotherTree {

    public static void main(String[] args){

        List<Integer> l = new ArrayList(Arrays.asList(-1,-4,8,-6,-2,3,9,null,-5,null,null,0,7));
        TreeNode tree = createTree(l);
        List<Integer> sl = new ArrayList(Arrays.asList(3,0,5848));
        TreeNode st = createTree(sl);
        System.out.println(isSubtree(tree, st));

    }

  /** create tree from a list of values*/
    private static TreeNode createTree(List<Integer> vals) {

        if (vals == null || vals.isEmpty()) {
            return new TreeNode();
        }
        Map<Integer, List<TreeNode>> map = new HashMap();
        List<TreeNode> q = new ArrayList();
        int level = 0;
        /** build map of levels and nodes of level*/
        int j=0;
        while (j!=vals.size() ) {
            if(Math.pow(2,level)>q.size()){
                if (vals.get(j)!=null){
                    TreeNode node = new TreeNode();
                    node.val = vals.get(j);
                    q.add(node);
                }else{
                    q.add(null);
                }
                j++;
                continue;
            }
            map.put(level, q);
            q = new ArrayList();
            level++;
        }
        map.put(level, q);
        int l =0;
        /** connect nodes to child nodes*/
        while (map.containsKey(l+1)) {
            List<TreeNode> tnl = map.get(l);
            List<TreeNode> child = map.get(l+1);
            for (int i=0; i < tnl.size(); i++) {
                if (tnl.get(i) == null) continue;
                if (child.size() < i*2+1) break;
                tnl.get(i).left = child.get(i*2);
                if (child.size() < i*2+2) break;
                tnl.get(i).right = child.get((i*2)+1);
            }
            l++;
        }
        return map.get(0).get(0);


    }

    private static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot != null) {
            return false;
        }
        if (root == null && subRoot == null) {
            return true;
        }
        List<TreeNode> q = new ArrayList();
        q.add(root);
        while (!q.isEmpty()){
            TreeNode curr = q.get(0);
            q.remove(0);
            if (curr.val == subRoot.val) {
                if (crawlSubtree(curr, subRoot)==0) {
                    return true;
                }
            }
            if(curr.left != null) {
                q.add(curr.left);
            }
            if(curr.right != null) {
                q.add(curr.right);
            }
        }
        return false;
    }

    private static int crawlSubtree(TreeNode node, TreeNode subNode) {
        if (node != null && subNode == null) return 1;
        if (node == null && subNode != null) return 1;
        if (node == null && subNode == null) return 0;
        if(node.val != subNode.val) return 1;
        return crawlSubtree(node.left, subNode.left) + crawlSubtree(node.right, subNode.right);
    }




    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }




}
