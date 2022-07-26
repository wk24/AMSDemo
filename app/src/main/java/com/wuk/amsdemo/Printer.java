package com.wuk.amsdemo;

/**
 * @author wuk
 * @date 2022/7/22
 */
class Printer {
    public static void main(String[] args) {
        b();
    }

    private static void b() {
        long s = System.currentTimeMillis();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long e = System.currentTimeMillis();
        System.out.println("executed time : " + (e - s) + " :ms");
    }
}