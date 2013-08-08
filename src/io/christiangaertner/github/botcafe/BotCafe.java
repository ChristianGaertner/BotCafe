package io.christiangaertner.github.botcafe;

import com.google.code.chatterbotapi.ChatterBot;
import com.google.code.chatterbotapi.ChatterBotFactory;
import com.google.code.chatterbotapi.ChatterBotSession;
import com.google.code.chatterbotapi.ChatterBotType;
import io.christiangaertner.github.botcafe.BotConversation.Message;
import io.christiangaertner.github.botcafe.ui.ChatDisplayer;
import javax.swing.JOptionPane;

/**
 *
 * @author Christian
 */
public class BotCafe {

    private ChatDisplayer ui;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        BotCafe cafe = new BotCafe();
        cafe.start();
    }
    
    private BotConversation conversation;
    
    private String botName1;
    private String botName2;

    public BotCafe() throws Exception {
        setUpBots();
        showNamePrompts();
        setUpUi();
    }

    public void start() {
        conversation.start();
        while (true) {
            Message msg = conversation.getMessage();

            ui.addMessage(msg);

            System.out.println(msg.bot + "> " + msg.msg);

        }
    }
    
    private void showNamePrompts() {
        botName1 = JOptionPane.showInputDialog("Bot Name 1:");
        botName2 = JOptionPane.showInputDialog("Bot Name 2:");
    }

    private void setUpBots() throws Exception {
        ChatterBotFactory factory = new ChatterBotFactory();

        ChatterBot bot1 = factory.create(ChatterBotType.CLEVERBOT);
        ChatterBotSession bot1session = bot1.createSession();

        ChatterBot bot2 = factory.create(ChatterBotType.PANDORABOTS, "b0dafd24ee35a477");
        ChatterBotSession bot2session = bot2.createSession();

        Bot cleverBot = new Bot(botName1, bot1session);
        Bot pandoraBot = new Bot(botName2, bot2session);

        conversation = new BotConversation("Hey!");
        conversation.addBot(cleverBot);
        conversation.addBot(pandoraBot);
    }

    private void setUpUi() {
        ui = new ChatDisplayer("BotCafe");
    }
}
