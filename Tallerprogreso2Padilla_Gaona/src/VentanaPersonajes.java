import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class VentanaPersonajes {
    private JPanel panelPrincipal;
    private JTextArea textArea;
    private JTextField txtId;
    private JTextField txtFuerza;
    private JComboBox<String> comboNombre;
    private JComboBox<String> comboClase;
    private JComboBox<String> comboRareza;
    private JTextField txtBuscar;
    private JButton btnAgregar;
    private JButton btnOrdenar;
    private JButton btnBuscar;

    private ArrayList<Personaje> listaPersonajes;

    public VentanaPersonajes() {
        listaPersonajes = new ArrayList<>();

        listaPersonajes.add(new Personaje(5, "Link", "Arquero", 300, "Épico"));
        listaPersonajes.add(new Personaje(15, "Kratos", "Guerrero", 500, "Legendario"));
        listaPersonajes.add(new Personaje(30, "Aloy", "Arquero", 400, "Épico"));
        listaPersonajes.add(new Personaje(50, "Geralt", "Mago", 600, "Raro"));

        mostrarPersonajes();

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(txtId.getText());
                    int fuerza = Integer.parseInt(txtFuerza.getText());

                    if (id % 5 != 0) {
                        JOptionPane.showMessageDialog(null, "El ID debe ser múltiplo de 5.");
                        return;
                    }

                    if (fuerza % 100 != 0) {
                        JOptionPane.showMessageDialog(null, "La fuerza debe ser múltiplo de 100.");
                        return;
                    }

                    for (Personaje p : listaPersonajes) {
                        if (p.getId() == id) {
                            JOptionPane.showMessageDialog(null, "El ID ya existe.");
                            return;
                        }
                    }

                    String nombre = comboNombre.getSelectedItem().toString();
                    String clase = comboClase.getSelectedItem().toString();
                    String rareza = comboRareza.getSelectedItem().toString();

                    listaPersonajes.add(new Personaje(id, nombre, clase, fuerza, rareza));
                    mostrarPersonajes();

                    txtId.setText("");
                    txtFuerza.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID y Fuerza deben ser números enteros.");
                }
            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreBuscar = txtBuscar.getText().trim();
                textArea.setText("");
                for (Personaje p : listaPersonajes) {
                    if (p.getNombre().equalsIgnoreCase(nombreBuscar)) {
                        textArea.append(p.toString() + "\n");
                    }
                }
            }
        });

        btnOrdenar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaPersonajes.sort((p1, p2) -> Integer.compare(p2.getFuerza(), p1.getFuerza()));
                mostrarPersonajes();
            }
        });
    }

    private void mostrarPersonajes() {
        textArea.setText("");
        for (Personaje p : listaPersonajes) {
            textArea.append(p.toString() + "\n");
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gestión de Personajes");
        frame.setContentPane(new VentanaPersonajes().panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}