package com.wenghuangge.context;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName footmap
 * @ClassName MySessionContext
 * @Date 2021/3/12 16:29
 * @Author wenghuangge
 * @Version 1.0
 */

/**
 * 管理HTTPSession
 */
public class MySessionContext {
    private static Map<String, HttpSession> myMap = new HashMap<>();
    public static synchronized void addSession(HttpSession session) {
        if (session != null) {
            myMap.put(session.getId(), session);
        }
    }

    public static synchronized void removeSession(HttpSession session) {
        if (session != null) {
            myMap.remove(session.getId());
        }
    }

    public static synchronized HttpSession getSession(String sessionId) {
        return myMap.get(sessionId);
    }

}
