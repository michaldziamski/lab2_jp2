import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class ZmianaKoloru {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> stworzGUI());
    }

    private static void stworzGUI() {
        JFrame frame = new JFrame("Zmiana koloru");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new BorderLayout());

        JPanel kolorPanel = new JPanel();
        frame.add(kolorPanel, BorderLayout.CENTER);

        JTextField kolorNameField = new JTextField();
        frame.add(kolorNameField, BorderLayout.SOUTH);

        JButton zmianaKoloru = new JButton("Zmien kolor");
        frame.add(zmianaKoloru, BorderLayout.NORTH);

        zmianaKoloru.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String kolor = kolorNameField.getText().toLowerCase();
                Color nowyKolor = getColorFromName(kolor);
                if (nowyKolor != null) {
                    kolorPanel.setBackground(nowyKolor);
                } else {
                    JOptionPane.showMessageDialog(frame, "Zła nazwa koloru", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setVisible(true);
    }

    private static Color getColorFromName(String kolorName) {
        Map<String, Color> kolorMap = new HashMap<>();
        kolorMap.put("czerwony", Color.RED);
        kolorMap.put("zielony", Color.GREEN);
        kolorMap.put("niebieski", Color.BLUE);
        kolorMap.put("żółty", Color.YELLOW);
        kolorMap.put("różowy", Color.PINK);
        //mozna dodac wiecej
        return kolorMap.get(kolorName);
    }
}
