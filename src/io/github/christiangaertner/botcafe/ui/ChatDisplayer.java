package io.github.christiangaertner.botcafe.ui;

import io.github.christiangaertner.botcafe.BotConversation.Message;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Christian
 */
public class ChatDisplayer extends JFrame {

    private JTextArea textArea;

    /**
     * Constructor. Shows a JFrame.
     *
     * @param title
     */
    public ChatDisplayer(String title) {

        textArea = new JTextArea(30, 80);
        JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        add(scroll);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(title);
        setResizable(false);
        setLocation(100, 100);
        setVisible(true);
        pack();
    }

    /**
     * Append to the text field.
     *
     * @param msg
     */
    public void addMessage(Message msg) {
        appendString(msg.bot + "> " + msg.msg);
    }

    /**
     * Append to the text field.
     * @param name
     * @param msg
     */
    public void addMessage(String name, String msg) {
        appendString(name + "> " + msg);
    }
    
    /**
     * Append to the text field (raw).
     * @param txt
     */
    public void addMessage(String txt) {
        appendString(txt);
    }

    private void appendString(String s) {
        textArea.append(s + "\n");
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}
