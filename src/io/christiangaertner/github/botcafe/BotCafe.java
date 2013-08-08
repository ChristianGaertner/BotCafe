package io.christiangaertner.github.botcafe;

import com.google.code.chatterbotapi.ChatterBot;
import com.google.code.chatterbotapi.ChatterBotFactory;
import com.google.code.chatterbotapi.ChatterBotSession;
import com.google.code.chatterbotapi.ChatterBotType;
import io.christiangaertner.github.botcafe.BotConversation.Message;
import io.christiangaertner.github.botcafe.ui.ChatDisplayer;
import io.christiangaertner.github.botcafe.voice.GoogleVoice;
import io.christiangaertner.github.botcafe.voice.GoogleVoice.Lang;
import java.util.HashMap;
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
    private HashMap<Bot, GoogleVoice> voices = new HashMap<Bot, GoogleVoice>();
    
    private String botName1;
    private String botName2;

    public BotCafe() throws Exception {
        new GoogleVoice(Lang.GERMAN).read("Willkommen im BotCafe!");
        showNamePrompts();
        setUpBots();
        setUpUi();
    }

    public void start() {
        conversation.start();
        while (true) {
            Message msg = conversation.getMessage();
            
            ui.addMessage(msg);
            GoogleVoice v = voices.get(msg.bot);
            v.read(msg.msg);
            
            System.out.println(msg.bot + "> " + msg.msg);

        }
    }
    
    private void showNamePrompts() {
        botName1 = JOptionPane.showInputDialog("Bot Name 1:");
        botName2 = JOptionPane.showInputDialog("Bot Name 2:");
        if (botName1.isEmpty()) {
            botName1 = "CleverBot";
        }
        
        if (botName2.isEmpty()) {
            botName2 = "PandoraBot";
        }
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
        
        voices.put(cleverBot, new GoogleVoice(Lang.ENGLISH));
        voices.put(pandoraBot, new GoogleVoice(Lang.US));
        
    }

    private void setUpUi() {
        ui = new ChatDisplayer("BotCafe");
    }
}
