package com.djf.app.androiddevelop.utils;/**
 * Created by Administrator on 2016/5/14.
 */

import android.os.Handler;

/**
 * ProjectName：IMXmmp
 * PackageName:com.djf.app.imxmmp.utils
 * FileName:ThreadUtils
 * Administrator  2016/5/14   19:32
 */
public class ThreadUtils {

    public static Handler handler = new Handler();

    /**
     * 在子线程执行
     *
     * @param runnable
     */
    public static void runOnBackThread(Runnable runnable) {
        new Thread(runnable).start();
    }

    public static void runOnUIThread(Runnable runnable) {

        handler.post(runnable);
    }

}
