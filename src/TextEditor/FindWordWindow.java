package TextEditor;

import javax.swing.*;
import java.awt.*;

public class FindWordWindow extends JFrame{
    JLabel findWordLabel = new JLabel("Find word");
    JTextField findWordInput = new JTextField(20);
    JButton findButton = new JButton("Find");
    FindWordWindow() {
        setLayout(new FlowLayout());
        findWordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        findWordLabel.setFont(new Font("Arial", Font.BOLD, 30));
        add(findWordLabel);
        add(findWordInput);
        add(findButton);
        setResizable(false);
        setSize(300, 350);
        setVisible(false);
    }
}