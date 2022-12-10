package TextEditor;

import javax.swing.*;

public class App extends JFrame {
    AppEngine engine = new AppEngine(this);
    Menu menu = new Menu();
    TextArea area = new TextArea();

    App() {
        setTitle("Text editor");
        setJMenuBar(menu);
        getContentPane().add(new JScrollPane(area));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(450, 600);
        setVisible(true);

        //// File actions
        menu.fileMenuItems[0].addActionListener(engine); //// New
        menu.fileMenuItems[1].addActionListener(engine); //// Open
        menu.fileMenuItems[2].addActionListener(engine); //// Save
        menu.fileMenuItems[3].addActionListener(engine); //// Exit

        //// Edit actions
        menu.editMenuItems[0].addActionListener(engine); //// Select all
        menu.editMenuItems[1].addActionListener(engine); //// Wrap words
        menu.wordWrap.addActionListener(engine);
        //// Change theme
        menu.themes[0].addActionListener(engine); //// Default
        menu.themes[1].addActionListener(engine); //// Black
        menu.themes[2].addActionListener(engine); //// Gray

        /// Help
        menu.aboutItem.addActionListener(engine);
    }
}