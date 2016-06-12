package com.djf.app.androiddevelop.utils;/**
 * Created by Administrator on 2016/5/14.
 */

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

/**
 * ProjectName：IMXmmp
 * PackageName:com.djf.app.imxmmp.utils
 * FileName:MyToast
 * Administrator  2016/5/14   20:20
 */
public class MyToast {
    private boolean isDisplay=true;
    private static  Toast   myToast  ;

    /**
     * 普通Toast
     * @param context
     * @param msg
     */
    public static void SimpleShow(Context context,String msg){
        if(myToast==null){
            myToast=Toast.makeText(context,msg,Toast.LENGTH_LONG);
        }
        myToast.setText(msg);
        myToast.show();
    }

    /**
     * 子线程Toast
     * @param context
     * @param msg
     */
    public static Handler handler = new Handler();
    public static void onThreadShow(final Context context, final String msg){
        handler.post(new Runnable() {
                @Override
                public void run() {
                    SimpleShow( context, msg);
                }
            });
    }
}
