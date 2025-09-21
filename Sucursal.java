public class Sucursal {
private String nombre;
private Domicilio domicilio;

public Sucursal(String nombre, Domicilio domicilio) {
    this.nombre = nombre;
    this.domicilio = domicilio;
}

@Override
public String toString() {
    return "Sucursal: " + nombre + " Domicilio: " + domicilio;
}
}