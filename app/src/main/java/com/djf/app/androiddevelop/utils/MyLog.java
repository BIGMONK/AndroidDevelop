package com.djf.app.androiddevelop.utils;

import android.nfc.tech.IsoDep;
import android.util.Log;

/**
 * Created by Administrator on 2016/5/9.
 */
public class MyLog  {
    private static boolean isDisplay=true;

    /**
     *
     * @param avtivityName    getClass().getName()
     */
   public  static void i(String avtivityName){
       if (isDisplay){
           Log.i("log",avtivityName);
       }
   }

}
