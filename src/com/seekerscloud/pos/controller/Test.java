package com.seekerscloud.pos.controller;

public class Test {
    public static void main(String[] args) {
        int man1=sum(10,20);// [10,20]
        int man2=sum(10,20,30);//[10,20,30]
        int man3=sum();//[]
    }

    static int sum(int...params){//[]
        int ttl=0;
        for (int i = 0; i < params.length; i++) {
            ttl+=params[i];
        }
        return ttl;
    }

}
