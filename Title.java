package BotGameCoutry;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import BotGameCoutry.*;

class Title extends JFrame {

    final String TITLE_OF_PROGRAM = "Simple Chat-Bot";
    final int START_LOCATION = 200;
    final int WINDOW_WIDTH = 350;
    final int WINDOW_HEIGHT = 450;

    Brains sbot = new Brains();

    public static void main(String[] args) throws Exception {
        new Title();
    }

    Title() throws Exception{
        setTitle(TITLE_OF_PROGRAM);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(START_LOCATION, START_LOCATION, WINDOW_WIDTH, WINDOW_HEIGHT);
        setVisible(true);
        // panel for dialog
        JTextArea dialogue = new JTextArea();
        dialogue.setLineWrap(true);
        JScrollPane scrollBar = new JScrollPane(dialogue);
        // panel for checkbox, message field and button
        JPanel bp = new JPanel();
        bp.setLayout(new BoxLayout(bp, BoxLayout.X_AXIS));
        //JCheckBox ai = new JCheckBox("AI");
        JTextField message = new JTextField();
        JButton enter = new JButton("Enter");
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialogue.append(message.getText() + "\n");
                try {
                    dialogue.append(sbot.sayInReturn(message.getText()) + "\n");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                message.setText("");
                message.requestFocusInWindow();
            }
        });
        // adding all elements to the window
        //bp.add(ai);
        bp.add(message);
        bp.add(enter);
        add(BorderLayout.CENTER, scrollBar);
        add(BorderLayout.SOUTH, bp);
        setVisible(true);
    }
}