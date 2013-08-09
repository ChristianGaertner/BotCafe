package io.christiangaertner.github.botcafe;

import java.util.ArrayDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author Christian
 */
public class BotConversation extends Thread {

    /**
     * A Message of a bot
     */
    public class Message {

        /**
         * The assoc Bot of the message.
         */
        public Bot bot;
        /**
         * The message itself.
         */
        public String msg;
    }
    private ArrayDeque<Bot> bots = new ArrayDeque<Bot>();
    private LinkedBlockingQueue<Message> messages = new LinkedBlockingQueue<Message>();
    private String lastMessage;

    /**
     * Constructor.
     * @param greeting
     */
    public BotConversation(String greeting) {
        lastMessage = greeting;
    }

    /**
     * Add a bot to the conversation.
     * @param b
     */
    public void addBot(Bot b) {
        bots.add(b);
    }

    /**
     * Run the thread.
     */
    @Override
    public void run() {
        if (bots.isEmpty()) {
            throw new IllegalStateException("At least one bot is necessary");
        }

        while (running()) {
            Bot b = bots.poll();

            try {


                lastMessage = b.getNextMessage(lastMessage).trim();

                if (lastMessage.isEmpty()) {
                    continue;
                }

                Message msg = new Message();
                msg.bot = b;
                msg.msg = lastMessage;

                messages.add(msg);
            } catch (Exception ex) {
                System.err.println("Exception on bot " + b + ": " + ex.getMessage());
            } finally {
                bots.add(b);
            }

        }
    }
    
    /**
     * Get the next message from the buffer.
     * @return
     */
    public Message getMessage() {
        try {
            return messages.take();
        } catch (InterruptedException ex) {
            System.err.println("Error on getting new Message");
            return null;
        }
    }
    
    /**
     * Wrapper for isInterrupted
     * (but inverted)
     * @return !isInterrupted
     */
    private boolean running() {
        return !isInterrupted();
    }
}
