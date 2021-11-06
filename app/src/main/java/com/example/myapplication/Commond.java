package com.example.myapplication;

import android.util.Log;

public class Commond {
    private static final String TAG = "Commond";

    //以下供给C语言调用
    public static void commond1(float a) {
        Log.i("TTTTT", "commond1: ");
        Log.i(TAG, "commodTest: ---------" + a);
    }

    public static void commond2(String s) {
        Log.i(TAG, "commodTest: ---------" + s);
    }

    public static void commond3(int a, String s) {
        Log.i(TAG, "commodTest: ----S:" + s + "--A:" + a);
    }
}
