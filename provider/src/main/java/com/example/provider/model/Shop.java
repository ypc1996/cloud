package com.example.provider.model;

/**
 * @author yangpengcheng
 * @ClassName Shop
 * @Description:
 * @date 2020/11/2710:31
 */
public class Shop {
    private String s1;
    private String s2;

    public class Bus{

        public  void test(){
            System.out.println("Bus:test");

        }
    }
    public static class Car{
        private static int a;
        public static void test(){
            System.out.println("CAR:test");
        }
        public  void test2(){
            System.out.println("CAR:test2");

        }
    }
}
