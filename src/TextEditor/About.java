package TextEditor;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame {
    JLabel about = new JLabel("It's very simple text editor made by Nikolai Prynko in 2022");
    JButton closeWindow = new JButton("Ok");

    About() {
        setLayout(new FlowLayout());
        add(about);
        add(closeWindow);
        setResizable(false);
        setSize(400, 300);
        setVisible(false);
    }
}