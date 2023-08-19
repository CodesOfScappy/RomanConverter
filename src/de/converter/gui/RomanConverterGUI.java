package de.converter.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ein einfacher Java-Programm, das eine grafische Benutzeroberfläche verwendet,
 * um arabische Zahlen in römische Zahlen umzuwandeln.
 */
@SuppressWarnings("serial")
public class RomanConverterGUI extends JFrame {

    private JTextField arabicTextField;
    private JLabel romanLabel;

    /**
     * Konstruktor für die RomanConverterGUI-Klasse. Initialisiert die GUI.
     */
    public RomanConverterGUI() {
        setTitle("Arabisch zu Römisch Konverter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(410, 150);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 1, 10, 10));

        JLabel titleLabel = new JLabel("Arabische Zahl eingeben:");
        arabicTextField = new JTextField();
        JButton convertButton = new JButton("Konvertieren");
        romanLabel = new JLabel();

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int arabicNumber = Integer.parseInt(arabicTextField.getText());
                    String romanNumber = convertToRoman(arabicNumber);
                    romanLabel.setText("Römische Zahl: " + romanNumber);
                } catch (NumberFormatException ex) {
                    romanLabel.setText("Ungültige Eingabe");
                }
            }
        });

        mainPanel.add(titleLabel);
        mainPanel.add(arabicTextField);
        mainPanel.add(convertButton);
        mainPanel.add(romanLabel);

        add(mainPanel);
        setVisible(true);
    }

    /**
     * Konvertiert eine arabische Zahl in eine römische Zahl.
     *
     * @param num Die arabische Zahl, die konvertiert werden soll.
     * @return Die entsprechende römische Zahl als Zeichenkette.
     */
    public static String convertToRoman(int num) {
        if (num < 1 || num > 3999) {
            return "Ungültige Eingabe";
        }

        // Array für Römische Zahlen
        String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        // Array für Arabische Zahlen
        int[] arabicValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder romanNumber = new StringBuilder();
        int index = 0;

        while (num > 0) {
            if (num >= arabicValues[index]) {
                romanNumber.append(romanSymbols[index]);
                num -= arabicValues[index];
            } else {
                index++;
            }
        }

        return romanNumber.toString();
    }

    /**
     * Hauptmethode zum Starten der GUI-Anwendung.
     *
     * @param args Die Kommandozeilenargumente (nicht verwendet).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RomanConverterGUI();
            }
        });
    }
}
