package com.djf.app.androiddevelop.XmlParse;

/**
 * Created by Administrator on 2016/5/13.
 */

public class MessageBean extends BasePortocol{
    public long from = 0;// 发送者 account
    public String fromNick = "";// 昵称
    public int fromAvatar = 1;// 头像
    public long to = 0; // 接收者 account
    public String content = ""; // 消息的内容  约不?

    @Override
    public String toString() {
        return "MessageBean{" +
                "from=" + from +
                ", fromNick='" + fromNick + '\'' +
                ", fromAvatar=" + fromAvatar +
                ", to=" + to +
                ", content='" + content + '\'' +
                '}';
    }
}
