public class Personaje {
    private int id;
    private String nombre;
    private String clase;
    private int fuerza;
    private String rareza;

    public Personaje(String clase, int id, String nombre, int fuerza, String rareza) {
        this.clase = clase;
        this.id = id;
        this.nombre = nombre;
        this.fuerza = fuerza;
        this.rareza = rareza;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getFuerza() {
        return fuerza;
    }

    @Override
    public String toString() {
        return "Personaje" +
                "Id=" + id +
                ", Nombre='" + nombre + '\'' +
                ", Clase='" + clase + '\'' +
                ", Fuerza=" + fuerza +
                ", Rareza='" + rareza + '\'';
    }
}
