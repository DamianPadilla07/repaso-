import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel Principal;
    private JSpinner spID;
    private JSpinner spFuerza;
    private JComboBox cboNombre;
    private JComboBox cboClase;
    private JComboBox cboRareza;
    private JComboBox cboBuscarNombre;
    private JTextArea txtSalida;
    private JButton btnAgregar;
    private JButton btnBuscar;
    private JButton btnOrdenar;

    private GestorPersonajes gestor = new GestorPersonajes();

  public Ventana(){
      try {
          gestor.agregarPersonaje(new Personaje("Arquero",5,"Link",300,"Epico"));
          gestor.agregarPersonaje(new Personaje("Guerrero",15,"Kratos",500,"Legendario"));
          gestor.agregarPersonaje(new Personaje("Arquero",30,"Aloy",400,"Epico"));
          gestor.agregarPersonaje(new Personaje("Mago",50,"Geralt",600,"Raro"));
      }catch (Exception e){
          e.printStackTrace();
      }

      btnAgregar.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              try {
                  int id = (int) spID.getValue();
                  int furza = (int) spFuerza.getValue();
                  String nombre = (String) cboNombre.getSelectedItem();
                  String clase = (String) cboClase.getSelectedItem();
                  String rareza = (String) cboRareza.getSelectedItem();
                  Personaje nuevo = new Personaje(clase,id, nombre,furza,rareza);
                  gestor.agregarPersonaje(nuevo);
                  txtSalida.setText(gestor.listarTodos());
              }catch (Exception ex){
                  JOptionPane.showMessageDialog(null,ex.getMessage());
              }
          }
      });
      btnBuscar.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              String nombre = (String) cboBuscarNombre.getSelectedItem();
              var resultado = gestor.buscarPorNombre(nombre);
              if (resultado.isEmpty()){
                  txtSalida.setText("No se encontraron Personajes con ese nombre");

              }else
          }
      });
  }
}
