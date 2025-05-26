import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel Principal;
    private JTextField txtnombre;
    private JTextField txtRendimiento;
    private JComboBox cboPosicion;
    private JButton btnRegistrar;
    private JTextArea txtListado;
    private JSpinner spCodigo;
    private JButton btnBuscar;
    private JButton btnMostrar;
    private JSpinner spid;

    private Equipo eq1= new Equipo();


    public Ventana() {
        this.$$$setupUI$$$();
        this.eq1 = new Equipo();
        this.btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(Ventana.this.spid.getValue().toString());
                String nombre = Ventana.this.txtnombre.getText();
                float ren = Float.parseFloat(Ventana.this.txtRendimiento.getText());
                String pos = Ventana.this.cboPosicion.getSelectedItem().toString();
                Jugador n = new Jugador(id, nombre, ren, pos);

                try {
                    Ventana.this.eq1.agregarJugador(n);
                } catch (Exception var8) {
                    Exception ex = var8;
                    JOptionPane.showMessageDialog((Component)null, ex.getMessage());
                }

                Ventana.this.txtListado.setText(Ventana.this.eq1.listarTodos());
            }
        });
        this.btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int codigo = Integer.parseInt(Ventana.this.spCodigo.getValue().toString());

                try {
                    Jugador j = Ventana.this.eq1.buscarJugador(codigo);
                    Ventana.this.txtListado.setText(j.toString());
                } catch (Exception var4) {
                    Exception ex = var4;
                    JOptionPane.showMessageDialog((Component)null, ex.getMessage());
                }

            }
        });
        this.btnMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Ventana.this.txtListado.setText(Ventana.this.eq1.listarTodos());
            }
        });
    }

    private void $$$setupUI$$$() {
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane((new Ventana()).Principal);
        frame.setDefaultCloseOperation(3);
        frame.pack();
        frame.setVisible(true);
    }
}
