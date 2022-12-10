package TextEditor;

import javax.swing.*;
import javax.swing.text.DefaultEditorKit;

public class Menu extends JMenuBar {
    Action[] actions = {new DefaultEditorKit.PasteAction(),
            new DefaultEditorKit.CopyAction(),
            new DefaultEditorKit.CutAction()};
    JMenu fileMenu = new JMenu("File");
    JMenuItem[] fileMenuItems = new JMenuItem[4];
    JMenu editMenu = new JMenu("Edit");
    JMenuItem[] editMenuItems = new JMenuItem[2];
    JCheckBoxMenuItem wordWrap = new JCheckBoxMenuItem("Wrap words");
    JMenu appearanceMenu = new JMenu("Appearance");
    JMenuItem listOfThemes = new JMenu("Theme");
    JMenuItem[] themes = new JMenuItem[3];


    JMenu helpMenu = new JMenu("Help");
    JMenuItem aboutItem = new JMenuItem("About");

    Menu() {
        /// File
        for (int i = 0; i < fileMenuItems.length; i++) {
            fileMenuItems[i] = new JMenuItem();
            fileMenu.add(fileMenuItems[i]);
        }
        fileMenuItems[0].setText("New");
        fileMenuItems[1].setText("Open");
        fileMenuItems[2].setText("Save");
        fileMenuItems[3].setText("Exit");
        add(fileMenu);


        //// Edit menu
        for (Action textAction : actions) {
            String value = textAction.getValue(AbstractAction.NAME).toString();
            value = value.substring(0, value.indexOf("-"));
            value = value.substring(0, 1).toUpperCase() + value.substring(1);
            textAction.putValue(AbstractAction.NAME, value);
            editMenu.add(new JMenuItem(textAction));
        }
        for (int i = 0; i < editMenuItems.length; i++) {
            editMenuItems[i] = new JMenuItem();
            editMenu.add(editMenuItems[i]);
        }
        editMenuItems[0].setText("Select all");
        editMenuItems[1].setText("Find");
        wordWrap.setState(true);
        editMenu.add(wordWrap);
        add(editMenu);

        //// Appearance
        appearanceMenu.add(listOfThemes);
        for (int i = 0; i < themes.length; i++) {
            themes[i] = new JMenuItem();
            listOfThemes.add(themes[i]);
        }
        themes[0].setText("Default");
        themes[1].setText("Black");
        themes[2].setText("Gray");
        add(appearanceMenu);
        //// Help
        helpMenu.add(aboutItem);
        add(helpMenu);
    }
}