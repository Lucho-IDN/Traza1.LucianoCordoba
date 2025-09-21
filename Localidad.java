import java.util.*;

class Localidad {
    private String nombre;
    private Provincia provincia;
    private Set<Domicilio> domicilios = new HashSet<>();

    public Localidad(String nombre, Provincia provincia) {
        this.nombre = nombre;
        this.provincia = provincia;
        provincia.addLocalidad(this);
    }

    public void addDomicilio(Domicilio d) {
        domicilios.add(d);
    }

    @Override
    public String toString() {
        return "Localidad: " + nombre;
    }
}