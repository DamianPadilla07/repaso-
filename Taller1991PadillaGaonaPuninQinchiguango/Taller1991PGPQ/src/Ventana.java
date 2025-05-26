import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Ventana extends JFrame {
    private JPanel Principal;
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtMision;
    private JTextField txtPeligrosidad;
    private JTextField txtPago;
    private JButton btnRegistrar;
    private JButton btnModificar;
    private JButton btnListar;
    private JButton btnInforme;
    private JTextArea areaResultado;
    private JLabel lblId;
    private JLabel lblNombre;
    private JLabel lblMision;
    private JLabel lblPeligro;
    private JLabel lblSueldo;

    private ArrayList<Avenger> listaAvengers = new ArrayList<>();

    public Ventana() {
        setTitle("Gestión de Misiones Avengers");
        setContentPane(Principal);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String id = txtId.getText();
                    String nombre = txtNombre.getText();
                    String mision = txtMision.getText();
                    int peligrosidad = Integer.parseInt(txtPeligrosidad.getText());
                    double pago = Double.parseDouble(txtPago.getText());

                    if (peligrosidad < 1 || peligrosidad > 5) {
                        JOptionPane.showMessageDialog(null, "El nivel de peligrosidad debe estar entre 1 y 5.");
                        return;
                    }

                    Avenger a = new Avenger(id, nombre, mision, peligrosidad, pago);
                    listaAvengers.add(a);

                    JOptionPane.showMessageDialog(null, "Avenger registrado.");

                    txtId.setText("");
                    txtNombre.setText("");
                    txtMision.setText("");
                    txtPeligrosidad.setText("");
                    txtPago.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error en los campos numéricos. Verifica los datos ingresados.");
                }
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaResultado.setText("");
                for (Avenger a : listaAvengers) {
                    areaResultado.append(
                            "ID: " + a.getId() +
                                    "\nNombre: " + a.getNombre() +
                                    "\nMisión: " + a.getMision() +
                                    "\nNivel de peligrosidad: " + a.getPeligrosidad() +
                                    "\nPago mensual: $" + a.getPagoMensual() + "\n\n"
                    );
                }
            }
        });

        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = txtId.getText();
                for (int i = 0; i < listaAvengers.size(); i++) {
                    Avenger a = listaAvengers.get(i);
                    if (a.getId().equals(id)) {
                        try {
                            String nombre = txtNombre.getText();
                            String mision = txtMision.getText();
                            int peligrosidad = Integer.parseInt(txtPeligrosidad.getText());
                            double pago = Double.parseDouble(txtPago.getText());

                            if (peligrosidad < 1 || peligrosidad > 5) {
                                JOptionPane.showMessageDialog(null, "El nivel de peligrosidad debe estar entre 1 y 5.");
                                return;
                            }

                            listaAvengers.remove(i);
                            listaAvengers.add(new Avenger(id, nombre, mision, peligrosidad, pago));

                            JOptionPane.showMessageDialog(null, "Avenger modificado.");
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Error en los campos numéricos.");
                        }
                        return;
                    }
                }
                JOptionPane.showMessageDialog(null, "ID no encontrado.");
            }
        });

        btnInforme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaResultado.setText("");
                for (Avenger a : listaAvengers) {
                    areaResultado.append(
                            "Nombre: " + a.getNombre() +
                                    "\nPago mensual: $" + a.getPagoMensual() +
                                    "\nAporte Fondo: $" + a.getAporteFondoHeroes() +
                                    "\nImpuesto mensual: $" + String.format("%.2f", a.getImpuesto() / 12) +
                                    "\nPago neto: $" + String.format("%.2f", a.getPagoNeto()) + "\n\n"
                    );
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ventana().setVisible(true));
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
