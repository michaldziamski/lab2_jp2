import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaZakupów extends JFrame {

    private DefaultListModel<String> listaModel;
    private JList<String> lista;
    private JTextField rzeczTextField;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ListaZakupów().setVisible(true);
            }
        });
    }
    public ListaZakupów() {
        setTitle("Lista Zakupów");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        listaModel = new DefaultListModel<>();

        lista = new JList<>(listaModel);
        JScrollPane scrollPane = new JScrollPane(lista);
        add(scrollPane, BorderLayout.CENTER);

        rzeczTextField = new JTextField();
        add(rzeczTextField, BorderLayout.PAGE_START);

        JButton dodajButton = new JButton("Dodaj");
        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dodajRzecz();
            }
        });
        add(dodajButton, BorderLayout.WEST);

        JButton usunButton = new JButton("Usuń");
        usunButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usunRzecz();
            }
        });
        add(usunButton, BorderLayout.LINE_END);
    }

    private void dodajRzecz() {
        String nowaRzecz = rzeczTextField.getText().trim();
        if (!nowaRzecz.isEmpty()) {
            listaModel.addElement(nowaRzecz);
            rzeczTextField.setText("");
        }
    }

    private void usunRzecz() {
        int klikniety = lista.getSelectedIndex();
        if (klikniety != -1) {
            listaModel.remove(klikniety);
        }
    }


}
