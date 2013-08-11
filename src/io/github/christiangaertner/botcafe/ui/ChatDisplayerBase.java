package io.github.christiangaertner.botcafe.ui;

import io.github.christiangaertner.botcafe.BotConversation;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author Christian
 */
public abstract class ChatDisplayerBase extends JFrame {
    /**
     * Append to the text field.
     *
     * @param msg
     */
    public void addMessage(BotConversation.Message msg) {
        addMessage(msg.bot + "> " + msg.msg);
    }

    /**
     * Append to the text field.
     *
     * @param name
     * @param msg
     */
    public void addMessage(String name, String msg) {
        addMessage(name + "> " + msg);
    }
    
        /**
     * Append to the text field (raw).
     *
     * @param txt
     */
    public abstract void addMessage(String txt);
    
    
    protected void appendString(String s, JTextArea textArea) {
        textArea.append(s + "\n");
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}
