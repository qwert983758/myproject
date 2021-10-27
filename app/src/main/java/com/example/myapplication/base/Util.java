package com.example.myapplication.base;

public class Util {
    public static boolean isEmpty(String _str) {
        if (_str == null || _str.equals("")) {
            return true;
        }
        return false;
    }
}
