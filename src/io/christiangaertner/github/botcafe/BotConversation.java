package io.christiangaertner.github.botcafe;

import java.util.ArrayDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author Christian
 */
public class BotConversation extends Thread {

    public class Message {

        public Bot bot;
        public String msg;
    }
    private ArrayDeque<Bot> bots = new ArrayDeque<Bot>();
    private LinkedBlockingQueue<Message> messages = new LinkedBlockingQueue<Message>();
    private String lastMessage;

    public BotConversation(String greeting) {
        lastMessage = greeting;
    }

    public void addBot(Bot b) {
        bots.add(b);
    }

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
    
    public Message getMessage() {
        try {
            return messages.take();
        } catch (InterruptedException ex) {
            System.err.println("Error on getting new Message");
            return null;
        }
    }

    private boolean running() {
        return !isInterrupted();
    }
}
