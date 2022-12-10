package TextEditor;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

public class AppEngine implements ActionListener {
    App parent;

    public AppEngine(App parent) {
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        //// File menu
        // New file
        if (src == parent.menu.fileMenuItems[0]) {
            parent.area.setText("");
            parent.setTitle("Безымянный.txt");
        } // Open file
        else if (src == parent.menu.fileMenuItems[1]) {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
            fileChooser.setFileFilter(filter);
            int response = fileChooser.showOpenDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                try {
                    FileReader reader = new FileReader(fileChooser.getSelectedFile());
                    BufferedReader buffReader = new BufferedReader(reader);
                    parent.area.read(buffReader, null);
                    buffReader.close();
                    parent.area.requestFocus();
                    parent.setTitle(fileChooser.getSelectedFile().getName());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } // Save file
        else if (src == parent.menu.fileMenuItems[2]) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
            fileChooser.setFileFilter(filter);
            if (response == JFileChooser.APPROVE_OPTION) {
                try {
                    BufferedWriter buffWriter = new BufferedWriter(new FileWriter(fileChooser.getSelectedFile().getAbsoluteFile() + ".txt"));
                    buffWriter.write(parent.area.getText());
                    buffWriter.flush();
                    buffWriter.close();
                    parent.setTitle(fileChooser.getSelectedFile().getName() + ".txt");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } // Exit
        else if (src == parent.menu.fileMenuItems[3]) {
            System.exit(0);
        }

        /// Edit menu
        if (src == parent.menu.editMenuItems[0]) { // Select all
            parent.area.selectAll();
        } else if (src == parent.menu.editMenuItems[1]) {  // Find word
            FindWordWindow window = new FindWordWindow();
            LineHighlightPainter painter = new LineHighlightPainter();
            window.setVisible(true);
            window.findButton.addActionListener(e1 -> {
                painter.removeHighlights(parent.area);
                painter.highlight(parent.area, window.findWordInput.getText());
                window.findWordInput.setText("");
            });
            window.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    painter.removeHighlights(parent.area);
                }
            });
        } else if (src == parent.menu.wordWrap) { // Wrap
            parent.area.setLineWrap(parent.menu.wordWrap.getState());
        }

        /// Appearance menu
        //Default theme
        if (src == parent.menu.themes[0]) {
            parent.area.setBackground(Color.WHITE);
            parent.area.setForeground(Color.BLACK);
        } else if (src == parent.menu.themes[1]) {
            parent.area.setBackground(Color.BLACK);
            parent.area.setForeground(Color.WHITE);
        } else if (src == parent.menu.themes[2]) {
            parent.area.setBackground(Color.DARK_GRAY);
            parent.area.setForeground(Color.WHITE);
        }

        /// Help
        if (src == parent.menu.aboutItem) {
            About about = new About();
            about.setVisible(true);
            about.closeWindow.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    about.dispose();
                }
            });
        }
    }
}