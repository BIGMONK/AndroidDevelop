package com.djf.app.androiddevelop.XmlParse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

/**
 * Created by Administrator on 2016/5/13.
 */

public class BasePortocol {


    /**
     * 对象转化成xml字符串
     * @return
     */
    public String toXML(){
       XStream xstream = new XStream();
        xstream.alias(this.getClass().getSimpleName(),this.getClass());
        return xstream.toXML(this);
    }

    /**
     * xml字符串转化成对象
     * @param xml
     * @return
     */
    public Object fromXML(String xml){
        XStream xstream = new XStream();
        xstream.alias(this.getClass().getSimpleName(),this.getClass());
        return xstream.fromXML(xml);
    }

    /**
     * 对象转化成json字符串
     * @return
     */
    public String toJsonString(){
        Gson gson=new Gson();
        return gson.toJson(this);
    }

    /**
     * json字符串转化成对象
     * @param json
     * @return
     */
    public Object fromJsonString(String json){
        Gson gson=new Gson();
        return gson.fromJson(json,this.getClass());
    }
}
