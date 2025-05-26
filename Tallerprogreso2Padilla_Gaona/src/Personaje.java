public class Personaje {
        private int id;
        private String nombre;
        private String clase;
        private int fuerza;
        private String rareza;

        public Personaje(int id, String nombre, String clase, int fuerza, String rareza) {
            this.id = id;
            this.nombre = nombre;
            this.clase = clase;
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
            return "ID: " + id + ", Nombre: " + nombre + ", Clase: " + clase +
                    ", Fuerza: " + fuerza + ", Rareza: " + rareza;
        }
    }