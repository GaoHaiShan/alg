package com.haishan.alg.redAndBlackTree;

public class Node {
    private Object data;
    private Node left;
    private Node right;
    private Node parent;
    private int color;


    public Node(Object data) {
        this(data,null);
    }

    public Node(Object data, Node parent) {
        this(data,null,null,parent,Color.red.value);
    }

    public Node(Object data, Node left, Node right, Node parent, int color) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.color = color;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Object getData() {
        return data;
    }
}
