import java.util.*;


class Pais {
    private String nombre;
    private Set<Provincia> provincias = new HashSet<>();

    public Pais(String nombre) { this.nombre = nombre; }

    public void addProvincia(Provincia p) {
        provincias.add(p);
    }

    @Override
    public String toString() {
        return "Pais: " + nombre + " Provincias: " + provincias;
    }
}