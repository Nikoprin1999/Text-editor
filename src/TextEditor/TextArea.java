package TextEditor;

import javax.swing.*;
import java.awt.*;

public class TextArea extends JTextArea {
    TextArea() {
        setMargin(new Insets(0, 5, 0, 5));
        setWrapStyleWord(true);
        setLineWrap(true);
    }
}
