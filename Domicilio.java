
public class Domicilio {

    private String direccion;
    private Localidad localidad;

    public Domicilio(String direccion, Localidad localidad) {
        this.direccion = direccion;
        this.localidad = localidad;
        localidad.addDomicilio(this);
    }

    @Override
    public String toString() {
        return direccion + " (" + localidad + ")";
    }
}

