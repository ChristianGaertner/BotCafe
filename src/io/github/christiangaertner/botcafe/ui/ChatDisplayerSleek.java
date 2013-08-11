package io.github.christiangaertner.botcafe.ui;

import io.github.christiangaertner.botcafe.BotCafe;

/**
 *
 * @author Christian
 */
public class ChatDisplayerSleek extends ChatDisplayerBase {
    
    private BotCafe cafe;
    
    /**
     * Creates new form ChatDisplayerSleek
     */
    public ChatDisplayerSleek(String title, BotCafe cafe) {
        setTitle(title);
        initComponents();
        
        setLocationRelativeTo(null);
        setVisible(true);
        
        this.cafe = cafe;
    }
    
    /**
     * Append to the text field (raw).
     *
     * @param txt
     */
    @Override
    public void addMessage(String txt) {
        appendString(txt, jTextArea1);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(238, 238, 254));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setToolTipText("The messages");
        jScrollPane1.setViewportView(jTextArea1);

        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Play Sound");
        jCheckBox1.setToolTipText("Whether the messages are getting spoken");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(jCheckBox1)
                        .add(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 259, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jCheckBox1)
                .addContainerGap())
        );

        pack();
    }

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // Just invert the current setting.
        cafe.playSound(!cafe.playSound());
    }


    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
}
