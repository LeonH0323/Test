package com.lesssoda.JVM;


/**
 * @author Lee
 * @since 2021/4/25 23:04
 */
public class GCTest {
    public static void main(String[] args) {
        byte[] allocation1, allocation2;
        allocation1 = new byte[55000*1024];
        allocation2 = new byte[6000*1024];
    }
}
