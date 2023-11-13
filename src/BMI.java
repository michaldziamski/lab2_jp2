import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMI extends JFrame {

    private JTextField wagaField;
    private JTextField wzrostField;
    private JLabel wynikLabel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BMI();
            }
        });
    }
    public BMI() {
        setTitle("BMI Kalkulator");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        JLabel wagaLabel = new JLabel("Waga (w kilogramach):");
        wagaField = new JTextField();
        JLabel heightLabel = new JLabel("Wzrost (w centymetrach)");
        wzrostField = new JTextField();

        JButton obliczButton = new JButton("Oblicz");
        wynikLabel = new JLabel("BMI: ");

        obliczButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liczenie();
            }
        });

        add(wagaLabel);
        add(wagaField);
        add(heightLabel);
        add(wzrostField);
        add(new JLabel());
        add(obliczButton);
        add(wynikLabel);

        setVisible(true);
    }

    private void liczenie() {
        try {
            double waga = Double.parseDouble(wagaField.getText());
            double wzrost = Double.parseDouble(wzrostField.getText());

            double bmi = liczeniewartosci(waga, wzrost);
            if (bmi<=18.49){
                String wynik = String.format("BMI: %.2f, twoje BMI jest za niskie.", bmi);
                wynikLabel.setText(wynik);
            } else if (bmi>18.49 && bmi<=24.99) {
                String wynik = String.format("BMI: %.2f, twoje BMI jest w normie.", bmi);
                wynikLabel.setText(wynik);
            } else if (bmi>24.99) {
                String wynik = String.format("BMI: %.2f, twoje BMI jest za wysokie.", bmi);
                wynikLabel.setText(wynik);
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Wprowadziłeś błędne wartości", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private double liczeniewartosci(double waga, double wzrost) {
        return waga/(wzrost*wzrost*0.0001);
    }


}
