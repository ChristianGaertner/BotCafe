package io.github.christiangaertner.botcafe;

import com.google.code.chatterbotapi.ChatterBot;
import com.google.code.chatterbotapi.ChatterBotFactory;
import com.google.code.chatterbotapi.ChatterBotSession;
import com.google.code.chatterbotapi.ChatterBotType;
import io.github.christiangaertner.botcafe.BotConversation.Message;
import io.github.christiangaertner.botcafe.ui.ChatDisplayer;
import io.github.christiangaertner.botcafe.voice.GoogleVoice;
import io.github.christiangaertner.botcafe.voice.GoogleVoice.Lang;
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
     * @throws Exception  
     */
    public static void main(String[] args) throws Exception {
        BotCafe cafe = new BotCafe();
        cafe.start();
    }
    
    /**
     * The conversation instance
     */
    private BotConversation conversation;
    /**
     * Only purpose is to have the bots speak diffrent "langs"
     */
    private HashMap<Bot, GoogleVoice> voices = new HashMap<Bot, GoogleVoice>();
    
    /**
     * cleaverBot' s name
     */
    private String botName1;
    /**
     * pandoraBot's name
     */
    private String botName2;

    /**
     * Constructor.
     * @uses showNamePrompts
     * @uses setUpBots
     * @uses setUpUi
     * @throws Exception
     */
    public BotCafe() throws Exception {
        showNamePrompts();
        setUpBots();
        setUpUi();
    }

    /**
     * Start the conversation thread
     */
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
    
    /**
     * Shows JOptionPanes for User-input
     * Default values are "CleverBot" and"PandoraBot"
     */
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
    
    /**
     * Set up the bot factorys, etc.
     * @throws Exception 
     */
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
    
    /**
     * Initiates the JFrame
     */
    private void setUpUi() {
        ui = new ChatDisplayer("BotCafe");
    }
}
