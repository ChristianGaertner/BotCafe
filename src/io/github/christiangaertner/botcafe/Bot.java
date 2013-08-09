package io.github.christiangaertner.botcafe;

import com.google.code.chatterbotapi.ChatterBotSession;

/**
 *
 * @author Christian
 */
public class Bot {
    
    /**
     * The Bot's name
     */
    private String name;
    /**
     * The assoc. session for this bot. (Info stream)
     */
    private ChatterBotSession bot;

    /**
     * Constructor.
     * @param n
     * @param s
     */
    public Bot(String n, ChatterBotSession s) {
        name = n;
        bot = s;
    }

    /**
     * toString method
     * @return The Bot' s name
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Wrapper for ChatterBotSession.think()
     * @param lastMessage
     * @return A new message (string)
     * @throws Exception
     */
    public String getNextMessage(String lastMessage) throws Exception {
        return bot.think(lastMessage);
    }
    
    /**
     * Setter for private name;
     * @param n
     */
    public void setName(String n) {
        name = n;
    }
}
