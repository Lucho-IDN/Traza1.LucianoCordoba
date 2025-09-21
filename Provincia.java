import java.util.*;


class Provincia {
    private String nombre;
    private Pais pais;
    private Set<Localidad> localidades = new HashSet<>();

    public Provincia(String nombre, Pais pais) {
        this.nombre = nombre;
        this.pais = pais;
        pais.addProvincia(this);
    }

    public void addLocalidad(Localidad l) {
        localidades.add(l);
    }

    @Override
    public String toString() {
        return "Provincia: " + nombre + " Localidades: " + localidades;
    }
}
