package com.djf.app.androiddevelop;

import android.test.InstrumentationTestCase;

import com.djf.app.androiddevelop.XmlParse.MessageBean;

/**
 * Created by Administrator on 2016/5/13.
 */

public class TestMessageParse extends InstrumentationTestCase {

    public void testToXML(){

        MessageBean messageBean= new MessageBean();
        messageBean.from=101;
        messageBean.fromAvatar=1;
        messageBean.fromNick="黄河";
        messageBean.to=102;
        messageBean.content="长江长江，我是黄河！";

        String xml=messageBean.toXML();
        System.out.println("对象转xml");
        System.out.println(xml);

        System.out.println("xml转对象");
        System.out.println(messageBean.fromXML(xml).toString());
    }

    public  void testToJson(){
        MessageBean messageBean= new MessageBean();
        messageBean.from=101;
        messageBean.fromAvatar=1;
        messageBean.fromNick="黄河";
        messageBean.to=102;
        messageBean.content="长江长江，我是黄河！";

        String json=messageBean.toJsonString();
        System.out.println("对象转json字符串");
        System.out.println(json);

        System.out.println("json字符串转对象");
        System.out.println(messageBean.fromJsonString(json).toString());
    }
}
