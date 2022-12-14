package org.example.ExpresionTree;

public class ExpresionTree {
    public static void main(String args[]) {

        Node n1 = new Node();n1.value="5";n1.left=null;n1.right=null;
        Node n2 = new Node();n2.value="9";n2.left=null;n2.right=null;
        Node n3 = new Node();n3.value="+";n3.left=n1;n3.right=n2;
        Node n4 = new Node();n4.value="2";n4.left=null;n4.right=null;
        Node n5 = new Node();n5.value="*";n5.left=n3;n5.right=n4;
        Node n6 = new Node();n6.value="3";n6.left=null;n6.right=null;
        Node n7 = new Node();n7.value="+";n7.left=n6;n7.right=n5;

        System.out.println(calc(n7));

    }

    private static int calc(Node node){
        if (node == null) {
            return 0;
        }
        switch(node.value){
            case "+":
                return calc(node.left) + calc(node.right);
            case "-":
                return calc(node.left) - calc(node.right);
            case "/":
                return calc(node.left) / calc(node.right);
            case "*":
                return calc(node.left) * calc(node.right);
            case "%":
                return calc(node.left) % calc(node.right);
            default:
                if(!node.value.matches("-?\\d+(\\.\\d+)?")){
                    return 0;
                }
                return Integer.valueOf(node.value);
        }
    }


    static class Node{
        String value;
        Node left, right;
    }



}
