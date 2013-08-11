package io.github.christiangaertner.botcafe.ui;

import io.github.christiangaertner.botcafe.BotConversation;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Christian
 */
public class ChatDisplayer extends ChatDisplayerBase {

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
     * Append to the text field (raw).
     *
     * @param txt
     */
    @Override
    public void addMessage(String txt) {
        appendString(txt, textArea);
    }
}
