package com.haishan.alg.threeNumber;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ThreeNumber {

    ArrayList<Double> number = new ArrayList<>();

    void init(){
        number.add(1.1);
        number.add(2.2);
        number.add(3.3);
        number.add(4.4);
        number.add(5.5);
        number.add(6.6);
        number.add(7.7);
        number.add(8.8);
    }

    List<Integer> setWhited(List<Double> num){
        int max = 20;
        List<Integer> list = new ArrayList<>(num.size());
        for (int i = 0;i < num.size();i++){
            list.add(max = max * 2) ;
        }
        return list;
    }

    List<Double> getThreeNumber(){
        List<Double> copyValue = (List<Double>) number.clone();
        List<Double> res = new ArrayList<>(3);
        Random random = new Random();
        for (int i = 0; i < 3;i++){
            List<Integer> whited = setWhited(copyValue);
            int randomNum = random.nextInt(whited.get(whited.size()-1));
            int index = 0;
            for (int j = 0; j < whited.size(); j++) {
                if (whited.get(j) > randomNum){
                    break;
                }
                index = j;
            }
            res.add(copyValue.remove(index));
        }
        return res;
    }

    void print(){
        for (int i = 0;i < 10000;i++){
            System.out.println(getThreeNumber().toString());
        }
    }
    public static void main(String[] args) {
        ThreeNumber threeNumber = new ThreeNumber();
        threeNumber.init();
        threeNumber.print();
    }
}
