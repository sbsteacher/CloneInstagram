package com.koreait.cloneinstagram.dm;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DmManager {
    private Map<Long, List<WebSocketSession>> rooms;

    public DmManager() {
        rooms = new HashMap<>();
    }

    public List<WebSocketSession> getRoomSession(long idm) {
        if(rooms.containsKey(idm)) {
            return rooms.get(idm);
        }
        rooms.put(idm, new ArrayList<WebSocketSession>());
        return rooms.get(idm);
    }

    public void removeRoom(long idm) {
        rooms.remove(idm);
    }

    public void sendMsg(long idm, String msg) throws IOException {
        TextMessage txtMsg = new TextMessage("");

        List<WebSocketSession> room = rooms.get(idm);
        for(WebSocketSession session : room) {
            session.sendMessage(txtMsg);
        }
    }
}
