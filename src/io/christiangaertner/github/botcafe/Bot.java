package io.christiangaertner.github.botcafe;

import com.google.code.chatterbotapi.ChatterBotSession;

/**
 *
 * @author Christian
 */
public class Bot {

    private String name;
    private ChatterBotSession bot;

    public Bot(String n, ChatterBotSession s) {
        name = n;
        bot = s;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getNextMessage(String lastMessage) throws Exception {
        return bot.think(lastMessage);
    }
    
    public void setName(String n) {
        name = n;
    }
}
