import java.util.*;

 public class Empresa {
    private int id;
    private String nombre;
    private String cuil;
    private Set<Sucursal> sucursales = new HashSet<>();

    public Empresa(int id, String nombre, String cuil) {
        this.id = id;
        this.nombre = nombre;
        this.cuil = cuil;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public void setCuil(String cuil) { this.cuil = cuil; }

    public void addSucursal(Sucursal s) {
        sucursales.add(s);
    }

    @Override
    public String toString() {
        return "Empresa [id=" + id + ", nombre=" + nombre + ", cuil=" + cuil + ", sucursales=" + sucursales + "]";
    }
}
