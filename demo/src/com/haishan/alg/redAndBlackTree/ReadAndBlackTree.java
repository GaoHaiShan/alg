package com.haishan.alg.redAndBlackTree;

public class ReadAndBlackTree {
    //根节点
    private Node root;
    //对比标识
    private String filedName;


    public ReadAndBlackTree(String filedName) {
        this.filedName=filedName;
    }

    public ReadAndBlackTree(){
    }

    public Object get(Object value){
        Node present = root;
        if (present==null){
            return null;
        }
        if (filedName==null){
            compareDefault(value);
        }else {
            compare(value);
        }
        return null;
    }

    private boolean compare(Object value) {
        return false;
    }

    private boolean compareDefault(Object value) {
//        if (root.getData().equals())
        return false;
    }
    public Object del(Object value){
        return value;
    }
    public Object add(Object value){
        Node node = new Node(value);
        add(node);
        return value;
    }

    public Node add(Node node){
        return node;
    }
}
