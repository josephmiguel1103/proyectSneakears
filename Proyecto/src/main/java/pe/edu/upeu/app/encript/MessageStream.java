package pe.edu.upeu.app.encript;

import java.util.HashMap;

public class MessageStream extends Subject {

    private HashMap<Integer, Object> messageHistory;

    public MessageStream() {
        messageHistory = new HashMap<>();
    }

    @Override
    void setState(String msg, String typex) {
        int i = 0;
        messageHistory.put(++i, msg);
        messageHistory.put(++i, typex);
        notifyObservers();
    }

    @Override
    HashMap<Integer, Object> getState() {
        return messageHistory;
    }
}
