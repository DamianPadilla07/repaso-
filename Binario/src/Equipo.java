import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Equipo {
    List<Jugador> lista = new ArrayList();
    private int secuencia = 0;

    public Equipo() {
    }

    public void agregarJugador(Jugador nuevo) throws Exception {
        Iterator var2 = this.lista.iterator();

        Jugador j;
        do {
            if (!var2.hasNext()) {
                this.lista.add(nuevo);
                this.ordenar();
                return;
            }

            j = (Jugador)var2.next();
        } while(j.getCodigo() != nuevo.getCodigo());

        throw new Exception("el codigo no es unico");
    }

    public void ordenar() {
        for (int i = 1; i < lista.size(); i++) {
            Jugador key = lista.get(i);
            int j = i - 1;


            while (j >= 0 && lista.get(j).getCodigo() > key.getCodigo()) {
                lista.set(j + 1, lista.get(j));
                j--;
            }
            lista.set(j + 1, key);
        }
    }


    public String listarTodos() {
        StringBuilder sb = new StringBuilder();
        Iterator var2 = this.lista.iterator();

        while(var2.hasNext()) {
            Jugador j = (Jugador)var2.next();
            sb.append(j.toString());
        }

        return sb.toString();
    }

    public Jugador buscarJugador(int codigo) throws Exception {
        if (codigo >= ((Jugador)this.lista.getFirst()).getCodigo() && codigo <= ((Jugador)this.lista.getLast()).getCodigo()) {
            int inf = 0;
            int sup = this.lista.size() - 1;

            while(inf <= sup) {
                int cen = (inf + sup) / 2;
                if (((Jugador)this.lista.get(cen)).getCodigo() == codigo) {
                    return (Jugador)this.lista.get(cen);
                }

                if (codigo < ((Jugador)this.lista.get(cen)).getCodigo()) {
                    sup = cen - 1;
                } else {
                    inf = cen + 1;
                }
            }

            throw new Exception("El codigo no esta dentro de la lista");
        } else {
            throw new Exception("Codigo no esta en la lista");
        }
    }
}
