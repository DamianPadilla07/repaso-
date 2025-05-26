public class Avenger {
    private String id;
    private String nombre;
    private String mision;
    private int peligrosidad;
    private double pagoMensual;

    public Avenger(String id, String nombre, String mision, int peligrosidad, double pagoMensual) {
        this.id = id;
        this.nombre = nombre;
        this.mision = mision;
        this.peligrosidad = peligrosidad;
        this.pagoMensual = pagoMensual;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    public String getMision() {
        return mision;
    }
    public int getPeligrosidad() {
        return peligrosidad;
    }
    public double getPagoMensual() {
        return pagoMensual;
    }

    public double getAporteFondoHeroes() {

        return pagoMensual * 0.08;
    }

    public double getPagoAnual() {
        return pagoMensual * 12;
    }

    public double getImpuesto() {
        double anual = getPagoAnual();
        if (anual <= 50000) return 0;
        if (anual <= 100000) return (anual - 50000) * 0.10;
        if (anual <= 200000) return 5000 + (anual - 100000) * 0.20;
        return 25000 + (anual - 200000) * 0.30;
    }

    public double getPagoNeto() {
        return pagoMensual - getAporteFondoHeroes() - (getImpuesto() / 12);
    }
}
