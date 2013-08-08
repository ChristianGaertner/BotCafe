package io.christiangaertner.github.botcafe;

import com.google.code.chatterbotapi.ChatterBot;
import com.google.code.chatterbotapi.ChatterBotFactory;
import com.google.code.chatterbotapi.ChatterBotSession;
import com.google.code.chatterbotapi.ChatterBotType;
import io.christiangaertner.github.botcafe.BotConversation.Message;

/**
 *
 * @author Christian
 */
public class BotCafe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        BotCafe cafe = new BotCafe();

        cafe.start();
    }
    private BotConversation conversation;

    public BotCafe() throws Exception {

        ChatterBotFactory factory = new ChatterBotFactory();

        ChatterBot bot1 = factory.create(ChatterBotType.CLEVERBOT);
        ChatterBotSession bot1session = bot1.createSession();

        ChatterBot bot2 = factory.create(ChatterBotType.PANDORABOTS, "b0dafd24ee35a477");
        ChatterBotSession bot2session = bot2.createSession();

        Bot cleverBot = new Bot("John", bot1session);
        Bot pandoraBot = new Bot("Jane", bot2session);

        conversation = new BotConversation("Hey!");
        conversation.addBot(cleverBot);
        conversation.addBot(pandoraBot);
    }

    public void start() {
        conversation.start();

        while (true) {
            Message msg = conversation.getMessage();

            System.out.println(msg.bot + "> " + msg.msg);

        }
    }
}
