/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package io.christiangaertner.github.botcafe.ui;

import io.christiangaertner.github.botcafe.BotConversation.Message;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Christian
 */
public class ChatDisplayer extends JFrame {

    private JPanel mainPanel;
    private JTextArea textArea;
    
    public ChatDisplayer(String title) {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        
        textArea = new JTextArea(50, 60);
        textArea.setEditable(false);
        
        mainPanel.add(textArea);
        
        add(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(title);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        pack();
    }
    
    public void addMessage(Message msg) {
        textArea.append(msg.bot + "> " + msg.msg + "\n");
    }
}
