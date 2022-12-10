package TextEditor;

import javax.swing.text.*;
import java.awt.*;

public class LineHighlightPainter {
    public void highlight(JTextComponent textComponent, String pattern) {
        try {
            Highlighter hilite = textComponent.getHighlighter();
            Document doc = textComponent.getDocument();
            String text = doc.getText(0, doc.getLength());

            int pos = 0;
            while ((pos = text.indexOf(pattern, pos)) >= 0) {
                hilite.addHighlight(pos, pos + pattern.length(), myHighlightPainter);
                pos += pattern.length();
            }

        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    public void removeHighlights(JTextComponent textComponent) {
        Highlighter highlighter = textComponent.getHighlighter();
        Highlighter.Highlight[] highlights = highlighter.getHighlights();

        for (Highlighter.Highlight highlight : highlights) {
            if (highlight.getPainter() instanceof MyHighlightPainter) {
                highlighter.removeHighlight(highlight);
            }
        }
    }

    Highlighter.HighlightPainter myHighlightPainter = new MyHighlightPainter(Color.red);

    class MyHighlightPainter extends DefaultHighlighter.DefaultHighlightPainter {
        /**
         * Constructs a new highlight painter. If <code>c</code> is null,
         * the JTextComponent will be queried for its selection color.
         *
         * @param c the color for the highlight
         */
        public MyHighlightPainter(Color c) {
            super(c);
        }
    }
}

