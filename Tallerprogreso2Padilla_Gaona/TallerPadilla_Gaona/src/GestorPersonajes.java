import java.util.ArrayList;
import java.util.Comparator;

public class GestorPersonajes {
    private ArrayList<Personaje> lista = new ArrayList<>();

    public void agregarPersonaje(Personaje p)throws Exception{
        if (p.getId() %5 != 0 ) throw new Exception("El ID debe ser multiplo de 5");
        if (p.getFuerza() %100 !=0 )throw new Exception("La fuerza debe ser multiplo de 100");
        for (Personaje x : lista){
            if (x.getId()== p.getId())throw new Exception("El Id que ingreso ya existe");
        }
        lista.add(p);
    }

    public ArrayList<Personaje>buscarPorNombre(String nombre){
        ArrayList<Personaje> resultado = new ArrayList<>();
        for (Personaje p : lista){
            if (p.getNombre().equalsIgnoreCase(nombre)){
                resultado.add(p);

            }
        }
        return resultado;
    }

    public void ordenarPorFuerzaDesc(){
        for (int i = 0; i <lista.size()-1; i++){
            for (int j = i+1; j<lista.size(); j++){
                if (lista.get(j).getFuerza() > lista.get(i).getFuerza()){
                    Personaje temp = lista.get(i);
                    lista.set(i,lista.get(j));
                    lista.set(j,temp);
                }
            }
        }
    }

    public String listarTodos(){
        StringBuilder sb = new StringBuilder();
        for (Personaje p : lista){
            sb.append(p.toString());
        }
        return sb.toString();
    }
}
