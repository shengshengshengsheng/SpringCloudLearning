package com.shengsheng.test;

/**
 * description:
 *
 * @author shengshenglalala
 * @date 2021/6/4 18:19
 */
public class Test {
    public static void main(String[] args) {
        try{
            int i = 1/0;
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
}
