package com.codepulse.FitroJtextField;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.text.*;

// Clase para validar correos
public class EmailFilter extends DocumentFilter {
    private JLabel statusLabel;

    public EmailFilter(JLabel statusLabel) {
        this.statusLabel = statusLabel;
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        super.insertString(fb, offset, string, attr);
        validateEmail(fb.getDocument().getText(0, fb.getDocument().getLength()));
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        super.replace(fb, offset, length, text, attrs);
        validateEmail(fb.getDocument().getText(0, fb.getDocument().getLength()));
    }

    @Override
    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
        super.remove(fb, offset, length);
        validateEmail(fb.getDocument().getText(0, fb.getDocument().getLength()));
    }

    private void validateEmail(String text) {
        if (text.matches("^[a-zA-Z0-9._%+-]+@(gmail|hotmail|outlook)\\.com$")) {
            statusLabel.setText("Correo válido");
            statusLabel.setForeground(Color.GREEN);
        } else {
            statusLabel.setText("Correo no válido");
            statusLabel.setForeground(Color.RED);
        }
    }
}