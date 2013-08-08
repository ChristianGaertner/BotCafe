/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package io.christiangaertner.github.botcafe.ui;

import io.christiangaertner.github.botcafe.BotConversation.Message;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Christian
 */
public class ChatDisplayer extends JFrame {
    
    private JTextArea textArea;
    
    public ChatDisplayer(String title) {
        
        textArea = new JTextArea(30, 80);
        JScrollPane scroll = new JScrollPane (textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        add(scroll);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(title);
        setResizable(false);
        setLocation(100,100);
        setVisible(true);
        pack();
    }

    public void addMessage(Message msg) {
        textArea.append(msg.bot + "> " + msg.msg + "\n");
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}
