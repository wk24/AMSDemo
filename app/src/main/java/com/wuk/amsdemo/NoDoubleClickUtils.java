package com.wuk.amsdemo;

import android.util.Log;
import android.widget.Toast;

/**
 * @author wuk
 * @date 2022/7/27
 */
public class NoDoubleClickUtils {
    private static long lastClickTime = 0;
    private final static int SPACE_TIME = 1000;

    public static boolean isDoubleClick() {
        long currentTime = System.currentTimeMillis();
        boolean isClick2;
        isClick2 = currentTime - lastClickTime <= SPACE_TIME;
        lastClickTime = currentTime;
        if (isClick2){
            Log.e("TAG", "isDoubleClick: 过滤" );
        }
        return !isClick2;
    }
}
