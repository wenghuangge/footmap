package com.wenghuangge.Listen;

import com.wenghuangge.context.MySessionContext;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @ProjectName footmap
 * @ClassName MySessionListener
 * @Date 2021/3/12 16:30
 * @Author wenghuangge
 * @Version 1.0
 */
public class MySessionListener  implements HttpSessionListener {
    public void sessionCreate(HttpSessionEvent sessionEvent) {
        MySessionContext.addSession(sessionEvent.getSession());
    }

    public void sessionDestroy(HttpSessionEvent sessionEvent) {
        MySessionContext.removeSession(sessionEvent.getSession());
    }

}
